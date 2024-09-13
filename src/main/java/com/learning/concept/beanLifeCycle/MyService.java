package com.learning.concept.beanLifeCycle;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    @PostConstruct
    public void init(){
        System.out.println("PostConstruct");

    }
    public MyService() {
        System.out.println("Constructor initialized");
    }

    @Bean
    public MyCustomConfig test(){
        System.out.println("Bean initialized");
        return new MyCustomConfig();
    }

}
