package org.example.libraryaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class LoggingAspect {

    private  static Logger logger = LoggerFactory.getLogger(LoggingAspect.class.getName());

    @Pointcut("@annotation(org.example.libraryaop.annotation.Log)")
    public void logPointCut() {

    }
    @Before("logPointCut()")
    public void logMethodEntry(JoinPoint joinPoint) {
        System.out.println("Entering method: " + joinPoint.getSignature());
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            System.out.println("Book : " + arg);
        }
    }

    @AfterReturning(pointcut = "logPointCut()", returning = "result")
    public void logMethodExit(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().toShortString();
        logger.info("Exiting method: {}", methodName);
        if (result != null) {
            logger.info("Return value: {}", result);
        } else {
            logger.info("Return value: void");
        }
    }

}
