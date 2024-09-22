package com.learning.concept.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aspect")
public class AspectController {
    @Autowired
    AspectService aspectService;

    @Autowired
    AspectAroundService aspectAroundService;

    @GetMapping("/1")
    public String get() {
        aspectService.method1();
        return "Hi There";
    }

    @GetMapping("/2")
    public String getS() {
        aspectService.method2();
        return "2";
    }

    @GetMapping("/within/1")
    public String getWithin1() {
        aspectService.within1();
        return "within 1";
    }

    @GetMapping("/within/2")
    public String getWithin2() {
        aspectService.within2();
        return "within 2";
    }

    @GetMapping("/aspectService")
    public String aspectService() {
        aspectService.aspectService();
        return "Aspect Service";
    }

    @GetMapping("/around")
    public String around() {
        aspectAroundService.around();
        return "Around";
    }
}
