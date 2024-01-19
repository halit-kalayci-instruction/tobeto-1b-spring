package com.tobeto.spring.b.controllers;

import com.tobeto.spring.b.core.services.JwtService;
import com.tobeto.spring.b.services.abstracts.UserService;
import com.tobeto.spring.b.services.dtos.requests.auth.LoginRequest;
import com.tobeto.spring.b.services.dtos.requests.user.CreateUserRequest;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/users")
@AllArgsConstructor
public class UsersController {
    private final UserService userService;

    // TODO: AuthController-AuthManager
    // api/auth/login api/auth/register
    @PostMapping
    public void register(@RequestBody CreateUserRequest request)
    {
        userService.register(request);
    }

    @PostMapping("login")
    public String login(@RequestBody LoginRequest request) {
       return userService.login(request);
    }
}
