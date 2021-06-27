package com.autumn.tutorial.webflux;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class HelloService {

	@PostConstruct
	public void init() {
		log.info("helloService bean created..");
	}
	
//	public Mono<String> hello(String name){
//		return Mono.just("hello " + name);
//	}
	
	public String hello(String name){
		return "hello " + name;
	}
	
	public Pay helloPay(String name){
		Pay p = new Pay();
		p.setName(name);
		return p;
	}
	
}
