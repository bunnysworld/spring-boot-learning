package com.learning.concept.async;

import com.learning.concept.transaction.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

@Service
public class AsyncService {

    @Autowired
    private HelperService helperService;

    @Async
    public void asyncMethod() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("Thread inside async method " + Thread.currentThread().getName());
    }

    @Transactional
    public void orderPlaced() {
        // verifying the order
        // updating the order
        helperService.updateCart(new Order());
    }

    @Transactional
    @Async
    public void updateCart() {

    }

    @Async
    public void best() {
        helperService.updateUser();
    }

    public String getFuture() {
        CompletableFuture<String> future = helperService.getFutureResponse();
        String response = null;
        try {
            response = future.get();
        } catch (Exception e) {
            // handle the exception
        }
        return response;
    }

    public String exception() {
        helperService.exception();
        int[] arr = new int[5];
        List<Integer> li = Arrays.stream(arr).boxed().collect(Collectors.toList());
        return "No Exception";
    }
}
