package com.tobeto.spring.b.services.concretes;

import com.tobeto.spring.b.services.abstracts.UserService;
import com.tobeto.spring.b.services.dtos.requests.user.CreateUserRequest;
import com.tobeto.spring.b.entities.User;
import com.tobeto.spring.b.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserManager implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void register(CreateUserRequest request) {
        User user = User.builder()
                .email(request.getEmail())
                .authorities(request.getRoles())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();

        userRepository.save(user);
    }
}
