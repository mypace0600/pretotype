package com.air.pretotype.config.component;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.air.pretotype.model.Count;
import com.air.pretotype.repository.CountRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Scheduler {

	@Autowired
	private CountRepository countRepository;


	@Transactional
	@Scheduled(cron = "59 59 23 * * *")
	public void saveTodayCount(){
		LocalDate todayInfo = LocalDate.now();
		Count count = countRepository.findByDateInfo(todayInfo).orElseThrow(()->{
			return new IllegalArgumentException("날짜 정보가 없습니다.");
		});
		count.setTotalCount(count.getTotalCount()+count.getTodayCount());
	}
}
