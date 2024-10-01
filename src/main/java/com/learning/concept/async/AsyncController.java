package com.learning.concept.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/async")
public class AsyncController {

    @Autowired
    private AsyncService asyncService;

    @GetMapping
    public String getAsyncMethod() throws InterruptedException {
        System.out.println("Thread in Controller " + Thread.currentThread().getName());
        asyncService.asyncMethod();
        return "ok";
    }

    @GetMapping("/problem_1")
    public String problem1() {
        asyncService.orderPlaced();
        return "";
    }

    @GetMapping("/problem_2")
    @Transactional
    public String problem2() {
        asyncService.updateCart();
        return "";
    }

    @GetMapping("/best")
    public String best() {
        asyncService.best();
        return "";
    }

    @GetMapping("/future")
    public String future() {
        return asyncService.getFuture();
    }

    @GetMapping("/exception")
    public String exception() {
        return asyncService.exception();
    }

}

