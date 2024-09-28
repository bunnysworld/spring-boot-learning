package com.learning.concept.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/createUser")
    public String createUser(@RequestBody User user) {
        return transactionService.createUser(user);
    }

    @PostMapping("/propagation")
    public String testPropagation(@RequestParam(name = "prop") String prop) {
        if (prop.equalsIgnoreCase("required")) {
            return transactionService.propagationRequired();
        }
        return "not valid propagation";
    }
}
