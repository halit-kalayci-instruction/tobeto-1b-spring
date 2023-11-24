package com.tobeto.spring.b.services.abstracts;

import com.tobeto.spring.b.services.dtos.requests.brand.AddBrandRequest;
import com.tobeto.spring.b.services.dtos.responses.brand.GetBrandResponse;

public interface BrandService
{
    void add(AddBrandRequest request);
    GetBrandResponse getById(int id);
}
