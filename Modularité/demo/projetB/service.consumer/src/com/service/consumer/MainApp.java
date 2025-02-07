package com.service.consumer;

import com.service.api.GreetingService;

import java.util.ServiceLoader;

public class MainApp {
    public static void main(String[] args) {

/*
        ServiceLoader<GreetingService> services = ServiceLoader.load(GreetingService.class);

        for (GreetingService service : services) {
            System.out.println(service.greet("John"));
        }
        */

         System.out.println(useFrenchService("toto"));
        System.out.println(useEnglishService("tata"));
    }
        public static String useFrenchService(String name) {
        return ServiceLoader.load(GreetingService.class)
                .stream()
                .map(ServiceLoader.Provider::get)
                .filter(service -> service.getClass().getName().contains("French"))
                .findFirst()
                .map(service -> service.greet(name))
                .orElse("French service not found");
    }

       public static String useEnglishService(String name) {
        return ServiceLoader.load(GreetingService.class)
                .stream()
                .map(ServiceLoader.Provider::get)
                .filter(service -> service.getClass().getName().contains("English"))
                .findFirst()
                .map(service -> service.greet(name))
                .orElse("English service not found");
    }
}
