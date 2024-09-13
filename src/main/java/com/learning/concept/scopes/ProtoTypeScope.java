package com.learning.concept.scopes;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class ProtoTypeScope {
    private int count = 0;

    public ProtoTypeScope() {
        System.out.println("ProtoType scope constructor");
    }

    public void increaseCount() {
        count = count + 1;
    }

    public int getCount() {
        return count;
    }
}
