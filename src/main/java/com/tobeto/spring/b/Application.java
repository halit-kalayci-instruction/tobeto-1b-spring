package com.tobeto.spring.b;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// localhost:8080/api/persons

// Annotation
// atandığı argümana özellikler kazandırır
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
