package com.amaterasu.auth_service.models.requests;

import lombok.Data;

@Data
public class UserLogInRequest {
    private String username;
    private String password;
}
