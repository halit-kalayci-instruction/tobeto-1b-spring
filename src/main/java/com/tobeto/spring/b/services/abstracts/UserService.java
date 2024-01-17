package com.tobeto.spring.b.services.abstracts;

import com.tobeto.spring.b.services.dtos.requests.user.CreateUserRequest;

public interface UserService {
    void register(CreateUserRequest request);
}
