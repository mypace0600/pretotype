package com.air.pretotype.service;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.air.pretotype.repository.EmailRepository;

@SpringBootTest
class EmailServiceTest {

	@Autowired
	private EmailService service;

	@MockBean
	private EmailRepository repository;

	@Test
	void checkDisCountCodeDistinct() {

		// given
		List<String> codeList = new ArrayList<>();

		for(int i = 0 ; i< 100000 ; i++){
			codeList.add(service.createDiscountCode());
		}
		// when

		// then
		boolean result = service.checkDisCountCodeDistinct(codeList);
		assertThat(result).isTrue();

	}

	@Test
	void save() {
	}
}
