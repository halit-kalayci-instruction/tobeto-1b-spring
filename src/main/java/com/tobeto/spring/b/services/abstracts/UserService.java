package com.tobeto.spring.b.services.abstracts;

import com.tobeto.spring.b.services.dtos.requests.auth.LoginRequest;
import com.tobeto.spring.b.services.dtos.requests.user.CreateUserRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    void register(CreateUserRequest request);
    void login(LoginRequest request);
}
