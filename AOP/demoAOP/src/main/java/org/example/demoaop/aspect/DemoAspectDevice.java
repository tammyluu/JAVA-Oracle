package org.example.demoaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DemoAspectDevice {
    @Before("execution(* org.example.demoaop.service.*.*(..))")
    public void before() {
        System.out.println("Run before each method !!!");

    @After("execution(* org.example.demoaop.service.*.*(..))")
    public void after(){
        System.out.println("Run after each method !!!");
        }

    }
}
