package com.tobeto.spring.b.repositories;

import com.tobeto.spring.b.entities.Car;
import com.tobeto.spring.b.services.dtos.responses.car.GetCarListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository<Car,Integer> {
    @Query("Select new com.tobeto.spring.b.services.dtos.responses.car" +
            ".GetCarListResponse(c.id, c.modelYear, new com.tobeto.spring.b.services.dtos.responses.brand.GetBrandListResponse(b.name)) " +
            "from Car c INNER JOIN c.brand b")
    List<GetCarListResponse> getAll();
}
