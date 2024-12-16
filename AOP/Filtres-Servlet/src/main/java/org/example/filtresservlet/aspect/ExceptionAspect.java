package org.example.filtresservlet.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

@Component
@Aspect
public class ExceptionAspect {
    private static final Logger log = Logger.getLogger(ExceptionAspect.class.getName());


    static {
        try {
            FileHandler fileHandler = new FileHandler("exception.log",true);
            fileHandler.setFormatter(new SimpleFormatter());
            log.addHandler(fileHandler);
        } catch (IOException e) {
            throw new RuntimeException("Erreur lors de l'initialisation du FileHandler pour les logs.", e);
        }
    }
    @AfterThrowing(pointcut = "@annotation(org.example.filtresservlet.annotation.ExceptionAnnotation)", throwing = "exception")
    public void handleException(Exception exception) {
        String exceptionName = exception.getClass().getName();
        String message = exception.getMessage();
        String timestamp = String.valueOf(System.currentTimeMillis());
        System.out.println("Exception caught: " + exception.getMessage());
        log.severe("Exception occurred: Exception=" + exceptionName + ", Message=" + message + ", Timestamp=" + timestamp);

        for (StackTraceElement element : exception.getStackTrace()) {
            log.severe("\tat " + element.toString());
        }
    }

}
