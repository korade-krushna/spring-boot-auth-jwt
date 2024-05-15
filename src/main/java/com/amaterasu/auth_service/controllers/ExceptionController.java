package com.amaterasu.auth_service.controllers;

import com.amaterasu.auth_service.execeptions.ApiExecutionException;
import com.amaterasu.auth_service.models.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(ApiExecutionException.class)
    public ResponseEntity<?> handleApiExecutionException(ApiExecutionException e) {
        return ResponseEntity.ok(new ApiResponse<>(e.getMessage()));
    }
}
