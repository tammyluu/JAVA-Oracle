package org.example.classroom.controller;

import lombok.RequiredArgsConstructor;
import org.example.classroom.dto.ClassroomDtoReceive;
import org.example.classroom.dto.ClassroomDtoResponse;
import org.example.classroom.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("classroom")
@RequiredArgsConstructor
public class ClassroomController {
    @Autowired
    ClassroomService classroomService;

    @GetMapping("/{id}")
    public ResponseEntity<ClassroomDtoResponse> getClassroomById(@PathVariable String id) {
        return  ResponseEntity.ok(classroomService.getById(id));
    }


    @PostMapping
    public ResponseEntity<ClassroomDtoResponse> addNewClassroom(@RequestBody ClassroomDtoReceive classroomDtoReceive) {
        return  ResponseEntity.ok(classroomService.save(classroomDtoReceive));
    }

}
