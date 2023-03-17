package com.air.pretotype.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class RedisService {
	private final Long clientAddressPostRequestWriteExpireDurationSec = 1L;
	private final RedisTemplate<String, Boolean> redisTemplate;

	public boolean isFirstIpRequest(String clientAddress){
		if(redisTemplate.hasKey(clientAddress)){
			return false;
		}
		return true;
	}

	public void writeClientRequest(String clientAddress){
		redisTemplate.opsForValue().set(clientAddress,true);
		log.info("opsForValue :{}",redisTemplate.opsForValue().get(clientAddress));
		redisTemplate.expire(clientAddress,clientAddressPostRequestWriteExpireDurationSec, TimeUnit.MINUTES);
		log.info("expire :{}",redisTemplate.getExpire(clientAddress));
	}

}
