package com.tobeto.spring.b.services.concretes;

import com.tobeto.spring.b.services.abstracts.UserService;
import com.tobeto.spring.b.services.dtos.requests.user.CreateUserRequest;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements UserService {
    @Override
    public void register(CreateUserRequest request) {

    }
}
