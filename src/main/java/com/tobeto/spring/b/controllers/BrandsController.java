package com.tobeto.spring.b.controllers;

import com.tobeto.spring.b.services.abstracts.BrandService;
import com.tobeto.spring.b.services.dtos.requests.brand.AddBrandRequest;
import com.tobeto.spring.b.services.dtos.responses.brand.GetBrandListResponse;
import com.tobeto.spring.b.services.dtos.responses.brand.GetBrandResponse;
import com.tobeto.spring.b.entities.Brand;
import com.tobeto.spring.b.repositories.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/brands")
public class BrandsController {
    private final BrandService brandService;

    public BrandsController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("{id}")
    public GetBrandResponse getById(@PathVariable int id)
    {
        return this.brandService.getById(id);
    }
    @PostMapping
    public void add(@RequestBody AddBrandRequest request)
    {
        this.brandService.add(request);
    }

    @GetMapping()
    public List<GetBrandListResponse> getByName(@RequestParam String name, @RequestParam int id)
    {
        return this.brandService.getByName(name,id);
    }

    @GetMapping("search")
    public List<Brand> search(@RequestParam String name){
        return this.brandService.search(name);
    }

}
