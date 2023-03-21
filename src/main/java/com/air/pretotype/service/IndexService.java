package com.air.pretotype.service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

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

	private final Scheduler scheduler;


	private boolean isFirst(String clientAddress){
		return redisTemplate.hasKey(clientAddress);
	}

	private void store(String clientAddress){
		ValueOperations<String, String> stringStringValueOperations = redisTemplate.opsForValue();
		stringStringValueOperations.set("clientAddress",clientAddress, Duration.ofSeconds(1L));
		String key ="count";
		LocalTime start = LocalTime.now();
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


	public void saveVisitCount(HttpServletRequest request){
		String clientAddress = request.getRemoteAddr();
		if(isFirst(clientAddress)){
			increment();
		}
		store(clientAddress);
		int nowCount = getCount();
		log.info("@@@@@@@@@@@ nowCount :{}",nowCount);
		LocalDate todayDate = LocalDate.now();
		log.info("@@@@@@@@@@@ todayDate :{}",todayDate);
		countRepository.save(Count.builder()
									.dateInfo(todayDate)
									.todayCount(nowCount)
								.build());
	}

	public int getVisitCount(){
		LocalDate todayDate = LocalDate.now();
		Count count = countRepository.findByDateInfo(todayDate).orElseThrow(()->{
			return new IllegalArgumentException("해당 날짜가 없습니다.");
		});
		return count.getTodayCount();
	}

}
