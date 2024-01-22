package com.tcs.reactiveassignment;

import org.junit.jupiter.api.Test;

import com.tcs.reactiveassignment.service.SomeService;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class NamesMonoMapFilterTest {
    SomeService someService = new SomeService();

    @Test
    public void testMonoString(){
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
    
    @Test
    public void testsForAssignmentThree(){
       /*  StepVerifier.create(someService.exceptionMonoOnErrorContinue("string"))
        .expectNext("string")
        .expectComplete()
        .verify(); */

        StepVerifier.create(someService.exceptionMonoOnErrorContinue("abc"))
        .expectNext("runtime error")
        .expectComplete()
        .verify();
       
    }
}
