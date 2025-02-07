package org.example.teacher.Controller;

import org.example.teacher.Service.TeacherService;
import org.example.teacher.dto.TeacherDtoReceive;
import org.example.teacher.dto.TeacherDtoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/teacher")
public class TeacherController {

    @Autowired
    TeacherService service;

    @GetMapping("/{id}")
    public ResponseEntity<TeacherDtoResponse> getById (@PathVariable("id") long id){
        return ResponseEntity.ok(service.getById(id));
    }


    @PostMapping
    public ResponseEntity<TeacherDtoResponse> addStudent (@RequestBody TeacherDtoReceive studentDtoReceive){
        return ResponseEntity.ok(service.save(studentDtoReceive));
    }
}
