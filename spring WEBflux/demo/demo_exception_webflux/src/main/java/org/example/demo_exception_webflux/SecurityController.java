package org.example.demo_exception_webflux;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

    @GetMapping("/public/hello")
    public String hello() {
        return "Endpoint public";
    }

    @GetMapping("/user/hello")
    public String helloUser() {
        return "Endpoint for toto user";
    }

    @GetMapping("/admin/hello")
    public String helloAdmin() {
        return "Endpoint for tata admin";
    }
}
