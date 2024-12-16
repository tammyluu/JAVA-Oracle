package org.example.libraryaop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceAspect {

    private static final Logger logger = LoggerFactory.getLogger(PerformanceAspect.class);

    @Pointcut("@annotation(org.example.libraryaop.annotation.Performance)")
    public void pointcut() {}

    @Around("pointcut()")
    public Object measurePerformance(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        String methodName = joinPoint.getSignature().getName();
        System.out.println("Execution of method "+methodName+" took "+duration+" ms");

        logger.info("Execution of method '{}' took {} ms", methodName, duration);

        return result;
    }
}
