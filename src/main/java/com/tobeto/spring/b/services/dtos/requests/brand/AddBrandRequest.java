package com.tobeto.spring.b.services.dtos.requests.brand;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddBrandRequest {

    @NotBlank(message = "Marka adı boş olamaz.") // multi-language
    @Size(min = 3, max = 20, message = "Marka adı 3 ile 20 hane arasında olmalıdır.")
    private String name;
}
