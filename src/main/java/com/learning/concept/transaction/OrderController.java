package com.learning.concept.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/createOrder")
    public String createOrder() {
        orderService.createOrderAndSendMai();
        return "Order created";
    }

    @PostMapping("/setPrice")
    public String updatePrice(@RequestParam(name = "id") String id,
                              @RequestParam(name = "price") String price) {
        orderService.setOrderPrice(id, price);
        return "price updated";
    }

    @GetMapping("/getPrice")
    public String getPrice(@RequestParam(name = "id") String id) {
        return orderService.getPrice(id);
    }
}
