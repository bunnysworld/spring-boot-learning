package com.learning.concept.aop;

import org.springframework.stereotype.Service;

@Service
public class AspectService {
    public void method1() {
        System.out.println("this is method 1");
    }

    public void method2() {
        System.out.println("this is method 2");
        method1();
    }

    public void within1() {
        System.out.println("Inside Within 1");
    }

    public void within2() {
        System.out.println("Inside Within 2");
    }

    public void aspectService() {
        System.out.println("Inside aspectService");
    }

    public void around() {
        System.out.println("This is around");
    }
}
