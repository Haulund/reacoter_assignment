package com.tcs.reactiveassignment;

import org.junit.jupiter.api.Test;

import com.tcs.reactiveassignment.service.SomeService;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class NamesMonoMapFilterTest {
    @Test
    public void testMonoString(){
        SomeService someService = new SomeService();
        Mono<String> namesMono_map_filter_String = someService.namesMonoMapFilter(4);
        Mono<String> namesMono_map_filter_String_Error = someService.namesMonoMapFilter(5);
        Mono<String> namesMono_map_filter_String_Error_Two = someService.namesMonoMapFilter(3);

        //step verifier
        StepVerifier.create(namesMono_map_filter_String)
        .expectNext("TEST")
        .expectComplete()
        .verify(); 

        StepVerifier.create(namesMono_map_filter_String_Error)
        .expectError();

        StepVerifier.create(namesMono_map_filter_String_Error_Two)
        .expectError();
    }
}
