package com.learning.concept.profiles;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class Profiles {
    @Value("${user}")
    private String username;

    @Value("${pass}")
    private String password;

    public String getCurrentUserNameAndPass() {
        return "username: " + username + " password " + password;
    }

}
