package org.example.demoaop.controller;

import org.example.demoaop.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("api/controlle")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @GetMapping
    public void getMethod(){
        demoService.method();
    }
}
