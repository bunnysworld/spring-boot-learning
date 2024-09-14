package com.learning.concept.qualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;

@Configuration
@Qualifier("onlineOrder")
public class OnlineOrder implements Order {
    @Override
    public String orderTye() {
        return "Online order";
    }
}
