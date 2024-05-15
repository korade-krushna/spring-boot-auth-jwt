package com.amaterasu.auth_service.controllers;

import com.amaterasu.auth_service.models.requests.UserLogInRequest;
import com.amaterasu.auth_service.models.requests.UserSignUpRequest;
import com.amaterasu.auth_service.models.response.ApiResponse;
import com.amaterasu.auth_service.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> logIn(@RequestBody UserLogInRequest request) {
        return ResponseEntity.ok(new ApiResponse<>(userService.logIn(request)));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody UserSignUpRequest request) {
       return ResponseEntity.ok(new ApiResponse<>(userService.signUp(request)));
    }

    @GetMapping("/protected")
    public ResponseEntity<?> protectedEndpoint() {
        return ResponseEntity.ok(new ApiResponse<>("protected endpoint"));
    }
}
