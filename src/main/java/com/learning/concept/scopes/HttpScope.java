package com.learning.concept.scopes;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service
@Scope(value = "request",proxyMode = ScopedProxyMode.TARGET_CLASS)
public class HttpScope {

    public HttpScope() {
        System.out.println("Constructor initialized for HttpScope");
    }

    public String getUsers(){
        return """
                {
                    "user":"akash";
                }
                """;
    }
}
