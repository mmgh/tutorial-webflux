package com.autumn.tutorial.webflux;

import java.util.function.BiFunction;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Slf4j
@RestController
public class WebFluxController {
	
	private final PayService payService;
	
	
	public WebFluxController(PayService payService) {
		this.payService     = payService;
	}

	
	
	@GetMapping("/parallel-mono/id/{id}/name/{name}")
	Mono<Pay> parallelMono(@PathVariable String id, @PathVariable String name){
		
		log.info("position1");
		
//		Mono<Pay> m = Mono.fromSupplier(() -> this.payService.getPay())
//						  .doOnNext(pay -> this.payService.getId(pay, id))
//						  .doOnNext(pay -> this.payService.getName(pay, name))
//						  .log();
		
		
		Pay payHasOnlyId = new Pay();
		Mono<Pay> payId  = Mono.just(this.payService.getPayHasThisId(payHasOnlyId, Integer.valueOf(id)))
								.map( x -> {
									log.info("[payId] 1s sleep");

									try {
										Thread.sleep(1000L);
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
									
									log.info("[payId] value : {}", Integer.valueOf(id));
									log.info("[payId] pay : {}",   x.toString());
									return x;
								})
								.subscribeOn(Schedulers.parallel());
		
		log.info("position2");
		
		Pay payHasOnlyName = new Pay();
		Mono<Pay> payName  = Mono.just(this.payService.getPayHasThisName(payHasOnlyName, name))
								.map( x -> {
									log.info("[payName] 2s sleep");
									
									try {
										Thread.sleep(2000L);
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
									
									log.info("[payName] value : {}", name);
									log.info("[payName] pay : {}",   x.toString());
									return x;
								})
								.subscribeOn(Schedulers.parallel());
		
		log.info("position3");
		
		BiFunction<Pay, Pay, Pay> combinator = (i, u) -> {
			Pay pay = new Pay();
			pay.setId(i.getId());
			pay.setName(u.getName());
			return pay;
		};
		
		log.info("position4");
		
		return Mono.zip(payId, payName, combinator).log();
		
	}
	
	
}
