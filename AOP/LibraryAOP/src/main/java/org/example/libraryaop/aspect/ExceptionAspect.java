package org.example.libraryaop.aspect;


import org.aspectj.lang.annotation.AfterThrowing;

import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExceptionAspect {
    private  static Logger logger = LoggerFactory.getLogger(ExceptionAspect.class.getName());

    @AfterThrowing(pointcut = "@annotation(org.example.libraryaop.annotation.ExceptionAnnotation)", throwing = "exception")
    public void handleException(Exception exception) {
        System.out.println("Exception caught: " + exception.getMessage());
    }
}
