package com.tobeto.spring.b.controllers;

import com.tobeto.spring.b.dtos.BrandForAddDto;
import com.tobeto.spring.b.dtos.BrandForDetailDto;
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
    public BrandForDetailDto getById(@PathVariable int id)
    {
        // Optional<T> => ilgili filtreden bir veri dönmeyebilir
        Brand brand = brandRepository.findById(id).orElseThrow();

        BrandForDetailDto dto = new BrandForDetailDto();
        dto.setName(brand.getName());

        return dto;
    }
    @PostMapping
    // Brand ❌
    // BrandForAddDto ✅
    public void add(@RequestBody BrandForAddDto brandForAddDto){

        // Manual Mapping => Auto Mapping
        Brand brand = new Brand();
        brand.setName(brandForAddDto.getName());

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