package com.tobeto.spring.b.services.dtos.requests.user;

import com.tobeto.spring.b.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUserRequest {
    private String email;
    private String password;
    private List<Role> roles;
}
