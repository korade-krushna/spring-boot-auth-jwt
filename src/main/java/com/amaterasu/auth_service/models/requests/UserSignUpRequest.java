package com.amaterasu.auth_service.models.requests;

import lombok.Data;

@Data
public class UserSignUpRequest {

    private String username;
    private String password;
    private String roles = "USER";
}
