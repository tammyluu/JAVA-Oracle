package org.example.teacher.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.teacher.dto.request.TeacherRequest;
import org.example.teacher.dto.request.TeacherUpdateResquest;
import org.example.teacher.dto.response.TeacherResponse;
import org.example.teacher.entity.Teacher;
import org.example.teacher.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("teacher")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TeacherController {

    @Autowired
    TeacherService teacherService;

  
    @PostMapping
    public ResponseEntity<Teacher> createTeacher(@RequestBody TeacherRequest teacherRequest) {
        Teacher teacher = teacherService.createTeacher(teacherRequest);
        return ResponseEntity.ok(teacher);
    }

    @GetMapping
    ResponseEntity<List<Teacher>> getAllTeachers() {
        return ResponseEntity.ok(teacherService.getAllTeachers());
    }

    @GetMapping("/{id}")
    TeacherResponse getTeacherById(@PathVariable("id") UUID id) {
        return teacherService.getTeacherById(id);
    }

    @PutMapping("/update/{id}")
    TeacherResponse updateTeacherById(@PathVariable("id") UUID id, @RequestBody TeacherUpdateResquest teacherRequest) {
        return teacherService.updateTeacher(id,teacherRequest);
    }


}
