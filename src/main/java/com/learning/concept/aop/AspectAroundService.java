package com.learning.concept.aop;

import org.springframework.stereotype.Service;

@Service
public class AspectAroundService {
    public void around() {
        System.out.println("Inside the Around");
    }
}
