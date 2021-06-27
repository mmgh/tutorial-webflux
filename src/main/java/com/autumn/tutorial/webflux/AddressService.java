package com.autumn.tutorial.webflux;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class AddressService {

	@PostConstruct
	public void init() {
		log.info("AddressService bean created..");
	}
	
//	public Mono<String> address(String address){
//		return Mono.just("your address " + address);
//	}
	
	public String address(String address){
		return "your address " + address;
	}
	
}
