package com.tcs.reactiveassignment.service;

import reactor.core.publisher.Mono;

public class SomeService {
    public Mono<String> namesMonoMapFilter(int stringLength){
        return Mono.just("test")
        .defaultIfEmpty("test")
        .map(String::toUpperCase)
        .filter(e -> e.length() == stringLength)
        .log();
    }
    public Mono<String> namesMonoMapFilterSwitchIfEmpty(int stringLength){
        return Mono.just("test")
        .switchIfEmpty(namesMonoMapFilter(4))
        .map(String::toUpperCase)
        .filter(e -> e.length() == stringLength)
        .log();

        
    }
}
