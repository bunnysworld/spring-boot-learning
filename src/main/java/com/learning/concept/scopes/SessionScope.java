package com.learning.concept.scopes;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionScope {
    public SessionScope() {
        System.out.println("Session constructor created");
    }

    public String getSession() {
        return """
                "session":"yes"
                """;
    }
}
