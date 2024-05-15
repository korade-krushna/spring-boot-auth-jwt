package com.amaterasu.auth_service.models.response;

import lombok.Data;

@Data
public class ApiResponse<T> {

    private String message;
    private T data;
    public ApiResponse(String message) {
        this.message = message;
    }

    public ApiResponse(T data) {
        this.data = data;
    }
}
