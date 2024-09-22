package com.learning.concept.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectConfigWithin {
    @Before("within(com.learning.concept..AspectService)")
    public void beforeWithin1() {
        System.out.println("Before Within");
    }

    @Before("within(com.learning.concept..*)")
    public void beforeForAll() {
        System.out.println("Before for All");
    }

    @Before("@within(org.springframework.stereotype.Service)")
    public void beforeWithinAnnotation(){
        System.out.println("Before annotation Service");
    }

    @Before("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void beforeAnnotation(){
        System.out.println("Before @annotation");
    }

    @Before("target(com.learning.concept.aop.AspectService)")
    public void beforeTarget(){
        System.out.println("Before target AspectService");
    }
}
