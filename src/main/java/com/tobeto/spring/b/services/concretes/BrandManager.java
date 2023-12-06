package com.tobeto.spring.b.services.concretes;

import com.tobeto.spring.b.entities.Brand;
import com.tobeto.spring.b.repositories.BrandRepository;
import com.tobeto.spring.b.services.abstracts.BrandService;
import com.tobeto.spring.b.services.dtos.requests.brand.AddBrandRequest;
import com.tobeto.spring.b.services.dtos.responses.brand.GetBrandListResponse;
import com.tobeto.spring.b.services.dtos.responses.brand.GetBrandResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class BrandManager implements BrandService
{
    private final BrandRepository brandRepository;

    @Override
    public void add(AddBrandRequest request) {
        // Aynı isimde iki brand olamaz
        if(brandRepository.existsByName(request.getName().trim()))
        {
            throw new RuntimeException("Aynı isimle iki marka eklenemez.");
        }

        Brand brand = new Brand();
        brand.setName(request.getName());

        brandRepository.save(brand);
    }

    @Override
    public GetBrandResponse getById(int id) {
        Brand brand = brandRepository.findById(id).orElseThrow();


        GetBrandResponse dto = new GetBrandResponse();
        dto.setName(brand.getName());

        return dto;
    }

    @Override
    public List<GetBrandListResponse> getByName(String name, int id) {
        List<Brand> brands = brandRepository.findByNameLikeOrIdEquals("%"+name+"%", id);
        List<GetBrandListResponse> response = new ArrayList<>();

        for (Brand brand: brands) {
            response.add(new GetBrandListResponse(brand.getName()));
        }
        return response;
    }

    @Override
    public List<GetBrandListResponse> search(String name) {
        List<Brand> brands = brandRepository.search2(name);

        // MAP
        // Lambda Expression & Stream API

        return brandRepository.search3(name);
    }
}
