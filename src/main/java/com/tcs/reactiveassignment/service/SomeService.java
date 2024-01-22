package com.tcs.reactiveassignment.service;

import reactor.core.publisher.Mono;

public class SomeService {
    public Mono<String> namesMonoMapFilter(int stringLength){
        return Mono.just("test")
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

    public static String throwErrorIfABC(String str) {
        if (str.equals("abc")) {
            return new RuntimeException("runtime error").getMessage();
        } else {
            return str;
        }
    }
    
    public Mono<String> exceptionMonoOnErrorContinue(String input) {
        return Mono.just(input).map(SomeService::throwErrorIfABC).log();
    }
}
