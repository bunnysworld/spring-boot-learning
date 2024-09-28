package com.learning.concept.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepo orderRepo;

    @Transactional
    public void createOrderAndSendMai() {
        createOrder();
    }

    public void createOrder() {
        Order order = new Order();
        order.setName("chips");
        order.setPrice("20");
        orderRepo.save(order);
    }

    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public void setOrderPrice(String id, String price) {
        Optional<Order> optionalOrder = orderRepo.findById(id);
        Order order = optionalOrder.get();
        order.setPrice(price);
        orderRepo.save(order);
        String p = getPrice(id);
        try {
            Thread.sleep(10000);
        } catch (Exception e) {

        }
        throw new RuntimeException("Rolling back transaction");
    }

    public String getPrice(String id) {
        Optional<Order> optionalOrder = orderRepo.findById(id);
        return optionalOrder.get().getPrice();
    }
}
