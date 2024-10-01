package com.learning.concept.async;

import com.learning.concept.transaction.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@Service
public class HelperService {

    @Async
    public void updateCart(Order order) {
        // updating the cart
    }

    @Transactional
    public void updateUser() {
        // update user
        // update another document
        // update meta data
        // save
    }

    @Async
    public CompletableFuture<String> getFutureResponse() {
        try {
            Thread.sleep(2000);
        } catch (Exception e) {

        }
        return CompletableFuture.completedFuture("turn complete future");
    }

    @Async
    public void exception() {
        int i = 0;
        int j = 34 / i;
    }
}
