package com.tobeto.spring.b.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Kullanıcının brand eklemek istediğinde kullanacağım model..
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BrandForAddDto {
    private String name;
}
