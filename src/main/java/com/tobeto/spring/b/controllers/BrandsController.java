package com.tobeto.spring.b.controllers;

import com.tobeto.spring.b.entities.Brand;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/brands")
public class BrandsController {


    @GetMapping
    public List<Brand> getAll() {
        return null;
    }
    @GetMapping("{id}")
    public Brand getById(@PathVariable  int id){
        return null;
    }
    @PostMapping
    public void add(@RequestBody Brand brand){}
    @PutMapping
    public void update(@RequestBody Brand brand) {

    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {}
}
