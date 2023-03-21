package com.air.pretotype;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class PretotypeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PretotypeApplication.class, args);
	}

}
