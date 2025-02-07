package com.service.impl.english;

import com.service.api.GreetingService;

public class EnglishGreetingService implements GreetingService {
    @Override
    public String greet(String name) {
        return "Hello, " + name + "!";
    }
}
