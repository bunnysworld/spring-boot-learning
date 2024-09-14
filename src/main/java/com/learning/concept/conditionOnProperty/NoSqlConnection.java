package com.learning.concept.conditionOnProperty;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(prefix = "database", name = "nosql")
public class NoSqlConnection {

    public String getConnection() {
        return "No Sql Connection";
    }
}
