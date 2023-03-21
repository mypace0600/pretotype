package com.air.pretotype.service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.air.pretotype.config.component.Scheduler;
import com.air.pretotype.model.Count;
import com.air.pretotype.repository.CountRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class IndexService {

	private final CountRepository countRepository;
	private final StringRedisTemplate redisTemplate;

	private boolean isFirst(String clientAddress){
		return redisTemplate.hasKey(clientAddress);
	}

	private void store(String clientAddress){
		ValueOperations<String, String> stringStringValueOperations = redisTemplate.opsForValue();
		stringStringValueOperations.set("clientAddress",clientAddress, Duration.ofMinutes(100L));
		String key ="count";
		LocalTime start = LocalTime.MIN;
		LocalTime end = LocalTime.MAX;
		stringStringValueOperations.set(key,"1",Duration.between(start,end));
	}

	private void increment(){
		String key ="count";
		ValueOperations<String, String> stringStringValueOperations = redisTemplate.opsForValue();
		stringStringValueOperations.increment(key);
	}

	private int getCount(){
		String count ="count";
		ValueOperations<String, String> stringStringValueOperations = redisTemplate.opsForValue();
		return Integer.parseInt(stringStringValueOperations.get(count));
	}


	@Transactional
	public void saveVisitCount(HttpServletRequest request){
		String clientAddress = request.getRemoteAddr();
		if(isFirst(clientAddress)){
			increment();
		}
		store(clientAddress);
		int nowCount = getCount();
		LocalDate todayDate = LocalDate.now();
		Optional<Count> count = countRepository.findByDateInfo(todayDate);
		if(!count.isPresent()){
			countRepository.save(Count.builder()
							.todayCount(nowCount)
							.dateInfo(todayDate)
					.build());
		} else {
			count.ifPresent(a->{
				a.setTodayCount(nowCount);
			});
		}
	}

	public int getTodayCount(){
		LocalDate todayDate = LocalDate.now();
		Count count = countRepository.findByDateInfo(todayDate).orElseThrow(()->{
			return new IllegalArgumentException("해당 날짜가 없습니다.");
		});
		return count.getTodayCount();
	}

	public int getTotalCount(){
		LocalDate todayDate = LocalDate.now();
		Count count = countRepository.findByDateInfo(todayDate).orElseThrow(()->{
			return new IllegalArgumentException("해당 날짜가 없습니다.");
		});
		return count.getTotalCount();
	}

}
