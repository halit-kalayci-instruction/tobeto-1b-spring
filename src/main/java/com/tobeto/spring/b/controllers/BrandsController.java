package com.tobeto.spring.b.controllers;

import com.tobeto.spring.b.entities.Brand;
import com.tobeto.spring.b.repositories.BrandRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/brands")
public class BrandsController {
    // Dependency => Bağımlılık
    // Injection => Enjekte
    private final BrandRepository brandRepository;
    // final => ctor blok dışında set edemezsiniz.
    public BrandsController(BrandRepository brandRepository)
    {
        this.brandRepository = brandRepository;
    }

    // Spring IoC container

    @GetMapping
    public List<Brand> getAll() {
        return brandRepository.findAll();
    }
    @GetMapping("{id}")
    public Brand getById(@PathVariable int id)
    {
        // Optional<T> => ilgili filtreden bir veri dönmeyebilir
        return brandRepository.findById(id).orElseThrow();
    }
    @PostMapping
    public void add(@RequestBody Brand brand){
        brandRepository.save(brand);
    }
    @PutMapping
    public void update(@RequestBody Brand brand) {

    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id)
    {
        // kod buraya geliyor ise exception fırlamamıştır..
        //Brand brandToDelete = brandRepository.findById(id).orElseThrow();
        // özel kontroller
        //brandRepository.delete(brandToDelete);
        brandRepository.deleteById(id);
    }
}
