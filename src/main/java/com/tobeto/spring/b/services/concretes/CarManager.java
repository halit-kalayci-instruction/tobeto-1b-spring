package com.tobeto.spring.b.services.concretes;

import com.tobeto.spring.b.services.abstracts.CarService;
import com.tobeto.spring.b.services.dtos.responses.car.GetCarListResponse;
import com.tobeto.spring.b.repositories.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CarManager implements CarService {
    private final CarRepository carRepository;


    @Override
    public List<GetCarListResponse> getAll() {
        return carRepository.getAll();
    }
}
