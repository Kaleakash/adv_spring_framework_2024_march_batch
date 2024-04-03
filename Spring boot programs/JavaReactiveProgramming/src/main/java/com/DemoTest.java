package com;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class DemoTest {

	public static void main(String[] args) {
		// 1st Example 
		//Mono<String> mm =  Mono.just("hello");
		//Flux<String> mm = Flux.just("A","B","C","D","E");
		Flux<String> mm = Flux.just("A","B").concatWithValues("Hello").
				concatWith(Flux.error(new Error("Error Generated"))).concatWithValues("Hi");
		// it take 3 parameter 
		// 1 parameter to load the data one by one 
		// 2nd parameter if any error generate it will call
		//3rd parameter after all data loaded successfully this parameter 
		mm.subscribe(ele-> {
			System.out.println(ele);
		},
		error-> {
			System.out.println(error);
		},
		()-> {
			System.out.println("done!");
		});
		
	
	}

}
