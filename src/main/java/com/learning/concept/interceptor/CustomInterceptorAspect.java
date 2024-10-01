package com.learning.concept.interceptor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CustomInterceptorAspect {

    @Around("@annotation(com.learning.concept.interceptor.CustomInterceptor)")
    public void invoke(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Before calling the custom main method");
        joinPoint.proceed();
        System.out.println("After calling the custom main method");
    }

}
