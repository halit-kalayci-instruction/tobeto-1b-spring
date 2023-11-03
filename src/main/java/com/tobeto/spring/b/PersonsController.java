package com.tobeto.spring.b;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("api/persons") // Bu controllerın kontrol edeceği alt routeları tanımlamak
public class PersonsController {
    List<Person> inMemoryList = new ArrayList<>();
    // In Memory DB
    // CRUD => Create,Read,Update,Delete


    @GetMapping // api/persons
    public List<Person> get(){
        return inMemoryList;
    }
    //@GetMapping("getById")
    // query string, path variable
    // path => https://localhost:8080/api/persons/30/halit/19
    // query string => https://localhost:8080/api/persons/getById?id=1&name=halit&age=19
    @GetMapping("{id}")
    public int getById(@PathVariable int id){
        return id;
    }


    @PostMapping
    public String add(){
        return "Tobeto";
    }
    @PutMapping
    public void update(){

    }
    @DeleteMapping
    public void delete(){

    }
    //2:20 dersteyiz
}
