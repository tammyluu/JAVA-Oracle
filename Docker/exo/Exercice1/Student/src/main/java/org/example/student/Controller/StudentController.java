package org.example.student.Controller;

import org.example.student.Service.StudentService;
import org.example.student.dto.StudentDtoReceive;
import org.example.student.dto.StudentDtoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/student")
public class StudentController {

    @Autowired
    StudentService service;

    @GetMapping("/{id}")
    public ResponseEntity<StudentDtoResponse> getById (@PathVariable("id") long id){
        return ResponseEntity.ok(service.getById(id));
    }


    @PostMapping
    public ResponseEntity<StudentDtoResponse> addStudent (@RequestBody StudentDtoReceive studentDtoReceive){
        return ResponseEntity.ok(service.save(studentDtoReceive));
    }
}
