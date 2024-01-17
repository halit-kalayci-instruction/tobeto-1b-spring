package com.tobeto.spring.b.controllers;

import com.tobeto.spring.b.services.abstracts.UserService;
import com.tobeto.spring.b.services.dtos.requests.user.CreateUserRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/users")
@AllArgsConstructor
public class UsersController {
    private final UserService userService;

    @PostMapping
    public void register(@RequestBody CreateUserRequest request)
    {
        userService.register(request);
    }
}
