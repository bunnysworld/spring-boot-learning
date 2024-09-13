package com.learning.concept.scopes;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Scope("singleton")
@Service
public class SingleTonScope {
    private int count = 0;

    public SingleTonScope() {
        System.out.println("SingleTonScope constructor");
    }

    public void increaseCount() {
        count = count + 1;
    }

    public int getCount() {
        return count;
    }

}
