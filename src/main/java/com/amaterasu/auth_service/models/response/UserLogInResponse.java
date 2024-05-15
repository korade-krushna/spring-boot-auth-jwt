package com.amaterasu.auth_service.models.response;

import com.amaterasu.auth_service.entities.User;
import lombok.Data;

@Data
public class UserLogInResponse {
    private String accessToken;
    private User user;
}
