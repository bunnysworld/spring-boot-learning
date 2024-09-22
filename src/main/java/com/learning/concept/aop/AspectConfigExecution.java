package com.learning.concept.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectConfigExecution {

    @Before("execution(* com.learning.concept.aop.AspectService.method1())")
    public void beforeAnyReturnTye() {
        System.out.println("Before method 1");
    }

    @Before("execution(* com.learning.concept.aop.AspectService.method2())")
    public void beforeAnyMethod() {
        System.out.println("Before method 2");
    }

    @Before("execution(* com.learning.concept.aop.AspectService.method1(..))")
    public void beforeMethod1() {
        System.out.println("Before method 1 ..");
    }

    @Before("execution(* com.learning..method1(..))")
    public void beforeSubPackage() {
        System.out.println("Before package method 1 ..");
    }
}

