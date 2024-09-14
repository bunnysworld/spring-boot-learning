package com.learning.concept.conditionOnProperty;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(prefix = "database", name = "sql")
public class MySqlConnection {

    public String getConnection() {
        return "MySql connection";
    }

}
