package com.learning.concept.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectConfigAround {
    @Around("execution(* com.learning.concept.aop.AspectAroundService.around())")
    public void insideAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Before Around");
        joinPoint.proceed();
        System.out.println("After Around");
    }
}
