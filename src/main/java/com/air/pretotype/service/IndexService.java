package com.air.pretotype.service;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.air.pretotype.contract.response.CountDto;
import com.air.pretotype.model.Visitor;
import com.air.pretotype.repository.VisitorRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class IndexService {

	private final RedisService redisService;

	private final VisitorRepository visitorRepository;

	public CountDto visitCount(HttpServletRequest request) throws Exception{
		String clientAddress = request.getRemoteAddr();
		boolean isFirst = redisService.isFirstIpRequest(clientAddress);
		if(isFirst){
			Visitor visitor = visitorRepository.findByClientAddress(clientAddress).orElse(
					visitorRepository.save(Visitor.builder()
									.clientAddress(clientAddress)
									.visitCount(1)
									.build())
			);
			if(visitor!=null) {
				visitor.setVisitCount(visitor.getVisitCount() + 1);
			}
		} else {
			Visitor visitor = visitorRepository.findByClientAddress(clientAddress).orElseThrow(()->{
				return new IllegalArgumentException("client address 오류");
			});
			if(visitor!=null) {
				visitor.setVisitCount(visitor.getVisitCount() + 1);
			}
		}
		redisService.writeClientRequest(clientAddress);

		int firstVisitCount = visitorRepository.firstVisitCount();
		int totalVisitCount = visitorRepository.totalVisitCount();

		return CountDto.builder()
				.firstVisitCount(firstVisitCount)
				.totalVisitCount(totalVisitCount)
				.build();
	}
}
