package org.example.filtresservlet.service;

import org.example.filtresservlet.annotation.ExceptionAnnotation;
import org.springframework.stereotype.Service;

@Service
public class AstronomyService {
    @ExceptionAnnotation
    public void operation(){
        throw new RuntimeException("Error in runtime");
    }
}
