package com.autumn.tutorial.webflux;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PayService {

	@PostConstruct
	public void init() {
		log.info("payService bean created..");
	}

	public Pay getPay() {
		return new Pay();
	}
	
	public Pay getPayHasThisId(Pay pay, int id) {
		pay.setId(id);
		return pay;
	}
	
	public Pay getPayHasThisName(Pay pay, String name) {
		pay.setName(name);
		return pay;
	}
	
	
}
