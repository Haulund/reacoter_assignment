package com.tcs.reactiveassignment.service;

public class MonoExeption {
    private Throwable throwable;
    private String message;
    public MonoExeption(String message, Throwable throwable) {
        this.throwable = throwable;
        this.message = message;
    }

}
