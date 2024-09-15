package com.learning.concept.profiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.util.Objects.nonNull;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {
    @Autowired(required = false)
    private Profiles profiles;

    @GetMapping
    public String getProfile() {
        if (nonNull(profiles)) {
            return profiles.getCurrentUserNameAndPass();
        } else {
            return "no profile is specified";
        }
    }
}
