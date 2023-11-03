package com.tobeto.spring.b;

// Boilerplate => Basmakalıp

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor // => tüm argümanları olan ctor
@NoArgsConstructor // 0 argümanlı ctor
public class Person {
    private int id;
    private String name;
    private String surname;
    private int age;
}
