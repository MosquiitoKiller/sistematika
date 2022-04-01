package com.example.sistematika;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.example.sistematika.entities")
@EnableJpaRepositories("com.example.sistematika.repositories")
public class SistematikaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SistematikaApplication.class, args);
    }

}
