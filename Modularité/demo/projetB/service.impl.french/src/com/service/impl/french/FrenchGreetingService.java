package com.service.impl.french;

import com.service.api.GreetingService;

public class FrenchGreetingService implements GreetingService {
    @Override
    public String greet(String name) {
        return "Bonjour, " + name + "!";
    }
}
