package com.amaterasu.auth_service.services;

import com.amaterasu.auth_service.entities.User;
import com.amaterasu.auth_service.execeptions.ApiExecutionException;
import com.amaterasu.auth_service.models.requests.UserLogInRequest;
import com.amaterasu.auth_service.models.requests.UserSignUpRequest;
import com.amaterasu.auth_service.models.response.UserLogInResponse;
import com.amaterasu.auth_service.repositories.UserRepo;
import com.amaterasu.auth_service.utils.JwtTokenUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepo userRepo;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtTokenUtil jwtTokenUtil;

    public UserService(UserRepo userRepo, BCryptPasswordEncoder passwordEncoder, JwtTokenUtil jwtTokenUtil) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    public UserLogInResponse logIn(UserLogInRequest request) {
        Optional<User> user = userRepo.findByUsername(request.getUsername());
        if (user.isEmpty()) {
            throw new ApiExecutionException("User not found");
        }
        if (!passwordEncoder.matches(request.getPassword(), user.get().getPassword())) {
            throw new ApiExecutionException("Invalid password");
        }
        UserLogInResponse response = new UserLogInResponse();
        response.setAccessToken(jwtTokenUtil.generateToken(user.get().getUsername()));
        response.setUser(user.get());
        return response;
    }

    public User signUp(UserSignUpRequest request) {
        userRepo.findByUsername(request.getUsername()).ifPresent(user -> {
            throw new ApiExecutionException("User already exists");
        });
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRoles(request.getRoles());
        return userRepo.save(user);

    }
}
