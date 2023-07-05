package org.example;

import org.example.entities.Product;
import org.example.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import org.example.controller.PingController;

import java.util.UUID;


@SpringBootApplication
// We use direct @Import instead of @ComponentScan to speed up cold starts
// @ComponentScan(basePackages = "org.example.controller")
//@Import({ PingController.class })
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository){
        return args ->{
            productRepository.save((Product.builder()
                    .id(UUID.randomUUID().toString())
                    .name("Computer")
                    .price(4300)
                    .build()));

            productRepository.save((Product.builder()
                    .id(UUID.randomUUID().toString())
                    .name("Imprimante")
                    .price(1500)
                    .build()));

            productRepository.save((Product.builder()
                    .id(UUID.randomUUID().toString())
                    .name("Smartphone")
                    .price(2000)
                    .build()));
        };

    }
}