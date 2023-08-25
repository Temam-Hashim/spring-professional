package com.example.demo.ExternalApi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExternalApiConfiguration {
//    @Bean("External Api")
    CommandLineRunner runner(ExternalService externalService){
        return args -> {
            System.out.println("https://jsonplaceholder.typicode.com/");
            System.out.println(externalService.getPosts().size());
            System.out.println("https://jsonplaceholder.typicode.com/100");
            System.out.println(externalService.getPost(100));
        };

    }
}
