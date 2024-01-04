package org.acme.email;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EmailService {

    public String greeting(String name) {
        return "hello " + name;
    }
}
