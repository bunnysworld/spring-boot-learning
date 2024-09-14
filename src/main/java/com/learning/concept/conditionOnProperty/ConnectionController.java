package com.learning.concept.conditionOnProperty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;

@Controller
@RequestMapping("/api/connection")
public class ConnectionController {

    @Autowired(required = false)
    MySqlConnection mySqlConnection;

    @Autowired(required = false)
    NoSqlConnection noSqlConnection;

    @ResponseBody
    @GetMapping("/details")
    public String getConnection() {
        if (Objects.nonNull(mySqlConnection)) {
            return mySqlConnection.getConnection();
        } else if (Objects.nonNull(noSqlConnection)) {
            return noSqlConnection.getConnection();

        } else {
            return "No connection configured";
        }
    }
}
