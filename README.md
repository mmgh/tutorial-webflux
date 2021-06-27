# tutorial-webflux

http get method call : http://localhost:8080/parallel-mono/id/1/name/stranger


2021-06-27 21:22:47.707  INFO 17800 --- [nio-8080-exec-1] c.a.tutorial.webflux.WebFluxController   : position1
2021-06-27 21:22:47.730  INFO 17800 --- [nio-8080-exec-1] c.a.tutorial.webflux.WebFluxController   : position2
2021-06-27 21:22:47.731  INFO 17800 --- [nio-8080-exec-1] c.a.tutorial.webflux.WebFluxController   : position3
2021-06-27 21:22:47.732  INFO 17800 --- [nio-8080-exec-1] c.a.tutorial.webflux.WebFluxController   : position4
2021-06-27 21:22:47.765  INFO 17800 --- [nio-8080-exec-1] reactor.Mono.Zip.1                       : onSubscribe([Fuseable] MonoZip.ZipCoordinator)
2021-06-27 21:22:47.768  INFO 17800 --- [nio-8080-exec-1] reactor.Mono.Zip.1                       : request(unbounded)
2021-06-27 21:22:47.786  INFO 17800 --- [     parallel-1] c.a.tutorial.webflux.WebFluxController   : [payId] 1s sleep
2021-06-27 21:22:47.787  INFO 17800 --- [     parallel-2] c.a.tutorial.webflux.WebFluxController   : [payName] 2s sleep
2021-06-27 21:22:48.800  INFO 17800 --- [     parallel-1] c.a.tutorial.webflux.WebFluxController   : [payId] value : 1
2021-06-27 21:22:48.801  INFO 17800 --- [     parallel-1] c.a.tutorial.webflux.WebFluxController   : [payId] pay : Pay [name=null, id=1]
2021-06-27 21:22:49.801  INFO 17800 --- [     parallel-2] c.a.tutorial.webflux.WebFluxController   : [payName] value : stranger
2021-06-27 21:22:49.801  INFO 17800 --- [     parallel-2] c.a.tutorial.webflux.WebFluxController   : [payName] pay : Pay [name=stranger, id=0]
2021-06-27 21:22:49.801  INFO 17800 --- [     parallel-2] reactor.Mono.Zip.1                       : onNext(Pay [name=stranger, id=1])
2021-06-27 21:22:49.802  INFO 17800 --- [     parallel-2] reactor.Mono.Zip.1                       : onComplete()
