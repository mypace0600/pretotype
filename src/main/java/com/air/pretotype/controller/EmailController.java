package com.air.pretotype.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.air.pretotype.contract.response.ResponseDto;
import com.air.pretotype.model.UserEmail;
import com.air.pretotype.service.EmailService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class EmailController {

	private final EmailService service;

	@PostMapping("/send")
	public ResponseDto<Integer> userEmail(@RequestBody UserEmail email){
		log.info("@@@@@@@@@@ email :{}",email);
		service.send(email);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}

}
