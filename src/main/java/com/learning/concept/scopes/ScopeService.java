package com.learning.concept.scopes;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Service
public class ScopeService {

    @Autowired
    private SingleTonScope singleTonScope;

    @Autowired
    private ProtoTypeScope protoTypeScope;

    @PostConstruct
    public void init() throws InterruptedException {
        System.out.println("Into the scope Service-1 PostConstruct");
        ExecutorService singleTonExecutor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            singleTonExecutor.submit(() -> {
                singleTonScope.increaseCount();
                System.out.println("ScopeService-1 Thread : " + Thread.currentThread().getName() + " count : " + singleTonScope.getCount());
            });
        }

        ExecutorService protoTypeExecutor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            protoTypeExecutor.submit(() -> {
                protoTypeScope.increaseCount();
                System.out.println("ScopeService-1 Thread : " + Thread.currentThread().getName() + " count : " + protoTypeScope.getCount());
            });
        }
    }

}

@Service
class ScopeService2{
    @Autowired
    private SingleTonScope singleTonScope;

    @Autowired
    private ProtoTypeScope protoTypeScope;

    @PostConstruct
    public void init() throws InterruptedException {
        System.out.println("Into the scope Service-2 PostConstruct");
        ExecutorService singleTonExecutor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            singleTonExecutor.submit(() -> {
                singleTonScope.increaseCount();
                System.out.println("ScopeService-2 Thread : " + Thread.currentThread().getName() + " count : " + singleTonScope.getCount());
            });
        }

        ExecutorService protoTypeExecutor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            protoTypeExecutor.submit(() -> {
                protoTypeScope.increaseCount();
                System.out.println("ScopeService-2 Thread : " + Thread.currentThread().getName() + " count : " + protoTypeScope.getCount());
            });
        }
    }
}
