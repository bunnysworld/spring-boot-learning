package com.learning.concept.qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Qualifier("onlineOrder")
    @Autowired
    Order order;

    @GetMapping
    public String getOrder(){
        return order.orderTye();
    }
}
