package com.amaterasu.auth_service.execeptions;

public class ApiExecutionException extends RuntimeException {
    public ApiExecutionException(String message) {
        super(message);
    }
}
