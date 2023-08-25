package com.example.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class AppConfig {
    
    @Value("${app.useFakeRepo:false}")
    private boolean useFakeRepo;

//    we can also can access some of the application property
    @Value("${info.app.name}")
    private String appName;

    @Autowired
    private Environment environment;

    @Bean
    CommandLineRunner commandLineRunner(AppInfo appInfo){
        return args -> {
            System.out.println("CommandLineRunner");
            System.out.println("========"+appName+"==========");
            System.out.println("App Name:"+environment.getProperty("info.app.name"));
            System.out.println("App Version:"+environment.getProperty("info.app.version"));
            System.out.println("App Information\n"+appInfo);
        };
    }
//    @Bean
//    CustomerRepo customerRepo(){
//        System.out.println("Using Fake Repo:"+useFakeRepo);
//
////        return useFakeRepo ? new CustomerFakeRepository() : new CustomerRepository();
//        return new CustomerFakeRepository();
//    }

}
