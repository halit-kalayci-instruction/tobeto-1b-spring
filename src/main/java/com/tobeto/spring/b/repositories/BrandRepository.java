package com.tobeto.spring.b.repositories;


import com.tobeto.spring.b.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

// DATA JPA
// Generic
// Generic türler Reference Type olmak zorundadır.
public interface BrandRepository extends JpaRepository<Brand, Integer>
{ }
