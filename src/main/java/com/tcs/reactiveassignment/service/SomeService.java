package com.tcs.reactiveassignment.service;

import reactor.core.publisher.Mono;

public class SomeService {
    public Mono<String> namesMonoMapFilter(int stringLength){
        return Mono.just("test")
        .map(String::toUpperCase)
        .filter(e -> e.length() == stringLength)
        .log();
    }
}
