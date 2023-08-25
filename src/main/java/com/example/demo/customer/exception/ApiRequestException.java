package com.example.demo.customer.exception;

public class ApiRequestException extends RuntimeException {

    public ApiRequestException(String message){
        super(message);
    }
    public ApiRequestException(String message, Throwable couse){
        super(message,couse);
    }


}
