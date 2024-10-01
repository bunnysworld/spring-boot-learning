package com.learning.concept.interceptor;

import org.springframework.stereotype.Service;

@Service
public class CustomInterceptorService {

    @CustomInterceptor(key = "customMethod")
    public void customMethod() {
        System.out.println("main custom method");
    }
}
