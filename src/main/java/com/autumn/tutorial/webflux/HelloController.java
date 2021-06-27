package com.autumn.tutorial.webflux;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
public class HelloController {

	private final HelloService helloService;
	
	private final AddressService addressService;

	
	
	public HelloController(HelloService helloService
			, AddressService addressService) {		
		this.helloService   = helloService;
		this.addressService = addressService;
	}
	
	
	@GetMapping("/pay")
	public Mono<Pay> pay(){
		Pay pay = new Pay();
		pay.setName("macbook-air-m1");
		pay.setId(1);
		return Mono.just(pay);
	}
	
	
	@GetMapping("/")
	Mono<String> hello(){
		log.info("post");
		
		String tenantId =  ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getHeader("tenant-id");
		log.info("tenantId : {}", tenantId);
		
		//미리 만들어놓은 모노가 스프링이 Subscribe하는 시점에 실행됨
		//Mono m = Mono.just("Hello WebFlux").doOnNext(c -> log.info(c)).log();
		
		//just는 미리 준비된 것
		//String s = generateHello();
		//Mono m = Mono.just(s).doOnNext(c -> log.info(c)).log();
		
		Mono m = Mono.fromSupplier(() -> generateHello()).doOnNext(c -> log.info(c)).log();
		//Cold를 구독
		//m.subscribe();
		
		log.info("post2");
		return m;
	}

	private String generateHello() {
		log.info("method generateHello()");
		return "Hello mono";
	}
	
}
