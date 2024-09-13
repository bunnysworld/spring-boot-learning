package com.learning.concept.scopes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/scope/")
public class ScopeController {

    @Autowired
    HttpScope scope;

    @Autowired
    SessionScope sessionScope;

    @ResponseBody
    @RequestMapping(path = "/getUsers", method = RequestMethod.GET)
    public String getUsers() {
        return scope.getUsers();
    }

    @ResponseBody
    @RequestMapping(path = "/getUsers2", method = RequestMethod.GET)
    public String getUsers2() {
        return scope.getUsers();
    }

    @ResponseBody
    @RequestMapping(path = "/session", method = RequestMethod.GET)
    public String getSession() {
        return sessionScope.getSession();
    }
}
