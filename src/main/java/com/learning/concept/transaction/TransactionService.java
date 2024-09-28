package com.learning.concept.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public String createUser(User user) {
        user = userRepository.save(user);
        String id = user.getId();
        return id;
    }

    @Transactional
    public String propagationRequired() {
        try{
            addUser1();
            addUser2();
        }catch (Exception e){

        }
        return "user updated";
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    private void addUser2() {
        User user = new User();
        user.setName("User 2");
        user.setAge(25);
        userRepository.save(user);
        throw new NullPointerException();
    }

    private void addUser1() {
        User user = new User();
        user.setName("User 1");
        user.setAge(24);
        userRepository.save(user);
    }
}
