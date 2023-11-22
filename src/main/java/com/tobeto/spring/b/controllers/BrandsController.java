package com.tobeto.spring.b.controllers;

import com.tobeto.spring.b.dtos.requests.brand.AddBrandRequest;
import com.tobeto.spring.b.dtos.responses.brand.GetBrandResponse;
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
    // List<BrandForListingDto> => id,name
    public List<Brand> getAll() {
        return brandRepository.findAll();
    }
    @GetMapping("{id}")
    // Brand ❌
    // BrandForDetailDto ✅
    public GetBrandResponse getById(@PathVariable int id)
    {
        // Optional<T> => ilgili filtreden bir veri dönmeyebilir
        Brand brand = brandRepository.findById(id).orElseThrow();

        GetBrandResponse dto = new GetBrandResponse();
        dto.setName(brand.getName());

        return dto;
    }
    @PostMapping
    // Brand ❌
    // BrandForAddDto ✅
    public void add(@RequestBody AddBrandRequest request){

        // Manual Mapping => Auto Mapping
        Brand brand = new Brand();
        brand.setName(request.getName());

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
// DTO -> Data Transfer Object
// 14:00 dersteyiz Request-Response pattern

// her istek için bir Request bir Response modeli bulunmalıdır.

// AddBrandResponse add(AddBrandRequest request) { }

// 5 adet entity CRUD işlemleri => Request-Response pattern uyumlu hale getirelim.
// Gerekli noktalarda mapping yapılacak.