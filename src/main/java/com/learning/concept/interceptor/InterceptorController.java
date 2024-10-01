package com.learning.concept.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/interceptor")
public class InterceptorController {

    @Autowired
    CustomInterceptorService customInterceptorService;

    @GetMapping
    public String getInterceptor() {
        System.out.println("Inside Interceptor main method : " + Thread.currentThread().getName());
        var i = 25 / 0;
        return "interceptor";
    }

    @GetMapping("/custom")
    public String customMethod() {
        customInterceptorService.customMethod();
        return "custom method";
    }
}
