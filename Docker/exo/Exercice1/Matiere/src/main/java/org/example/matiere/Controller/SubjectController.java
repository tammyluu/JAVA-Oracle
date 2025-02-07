package org.example.matiere.Controller;

import org.example.matiere.Dto.SubjectDtoReceive;
import org.example.matiere.Dto.SubjectDtoResponse;
import org.example.matiere.Service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/subject")
public class SubjectController {

    @Autowired
    private SubjectService service;

    @GetMapping("/{id}")
    public ResponseEntity<SubjectDtoResponse> getById (@PathVariable("id") long id){
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<SubjectDtoResponse> addSubject (@RequestBody SubjectDtoReceive subjectDtoReceive){
        return ResponseEntity.ok(service.save(subjectDtoReceive));
    }
}
