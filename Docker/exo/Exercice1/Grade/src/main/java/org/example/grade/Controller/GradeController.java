package org.example.grade.Controller;

import org.example.grade.Dto.GradeDtoReceive;
import org.example.grade.Dto.GradeDtoResponse;
import org.example.grade.Service.GradeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/subject")
public class GradeController {

    @Autowired
    private GradeService service;

    @GetMapping("/{id}")
    public ResponseEntity<GradeDtoResponse> getById (@PathVariable("id") long id){
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<GradeDtoResponse> addSubject (@RequestBody GradeDtoReceive gradeDtoReceive){
        return ResponseEntity.ok(service.save(gradeDtoReceive));
    }
}
