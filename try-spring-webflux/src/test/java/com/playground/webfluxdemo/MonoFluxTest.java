package com.playground.webfluxdemo;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFluxTest {

    @Test
    public void testMono() {
        Mono<String> monoString = Mono.just("Hello world").log();
        monoString.subscribe(System.out::println);
    }

    @Test
    public void testMono_error() {
        Mono<?> monoString = Mono.just("Hello world")
                .then(Mono.error(new RuntimeException("Exception Occured")))
                .log();
        monoString.subscribe(System.out::println);
    }

    @Test
    public void testMono_error_handling_exception() {
        Mono<?> monoString = Mono.just("Hello world")
                .then(Mono.error(new RuntimeException("Exception Occured")))
                .log();
        monoString.subscribe(System.out::println, throwable -> System.out.println(throwable.getMessage() + " LOL"));
    }

    @Test
    public void testFlux(){
        Flux<String> fluxString = Flux.just("Spring", "Spring Boot", "Hibernate", "Microservices").log();
        fluxString.subscribe(System.out::println);
    }

    @Test
    public void testFlux_2(){
        Flux<String> fluxString = Flux.just("Spring", "Spring Boot", "Hibernate", "Microservices")
                .concatWithValues("AWS")
                .log();
        fluxString.subscribe(System.out::println);
    }


    @Test
    public void testFlux_error(){
        Flux<String> fluxString = Flux.just("Spring", "Spring Boot", "Hibernate", "Microservices")
                .concatWithValues("AWS")
                .concatWith(Flux.error(new RuntimeException("Exception occured in flux")))
                .concatWithValues("Kubernetes")
                .log();
        fluxString.subscribe(System.out::println, throwable -> System.out.println(throwable.getMessage()));
    }

}
