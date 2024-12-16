package org.example.filtresservlet.aspect;

import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
public class RequestAspect {
    private final HttpServletRequest request;
    public RequestAspect(HttpServletRequest request) {
        this.request = request;
    }
    @Pointcut("within(org.example.filtresservlet.controller.*)")
    public void controllerMethod() {

    }

    @Before("controllerMethod()")
    public void logRequestDetails() {
        String uri = request.getRequestURI();
        String method = request.getMethod();
        LocalDateTime timestamp = LocalDateTime.now();

    System.out.println("Request received: URI=" + uri + ", Method=" + method + ", Timestamp=" + timestamp);
    }

}
