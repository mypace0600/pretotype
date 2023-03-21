package com.air.pretotype.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
public class RedisTest {

	@Autowired
	StringRedisTemplate redisTemplate;

	@Test
	public void test(){
		final String key = "key";
		final ValueOperations<String, String> stringStringValueOperations = redisTemplate.opsForValue();

		stringStringValueOperations.set(key,"1");
		String result1 = stringStringValueOperations.get(key);
		System.out.println("@@@@@@@@@@@@@ result1 = " + result1);

		stringStringValueOperations.increment(key);
		String result2 = stringStringValueOperations.get(key);
		System.out.println("@@@@@@@@@@@@@ result2 = " + result2);
	}
}
