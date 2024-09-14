package com.learning.concept.qualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;

@Configuration
@Qualifier("offLineOrder")
public class OfflineOrder implements Order {
    @Override
    public String orderTye() {
        return "offline order";
    }
}
