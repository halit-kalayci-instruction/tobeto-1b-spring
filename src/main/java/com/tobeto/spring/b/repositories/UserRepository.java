package com.tobeto.spring.b.repositories;

import com.tobeto.spring.b.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
