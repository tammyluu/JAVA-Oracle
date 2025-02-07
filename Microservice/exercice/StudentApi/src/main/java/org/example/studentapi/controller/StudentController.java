package org.example.studentapi.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.studentapi.dto.request.StudentRequest;
import org.example.studentapi.dto.request.UpdateStudentRequest;
import org.example.studentapi.dto.response.StudentResponse;
import org.example.studentapi.entity.Student;
import org.example.studentapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("student")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudentController {

    @Autowired
     StudentService studentService;

    @PostMapping
    ResponseEntity<Student> createStudent(@RequestBody StudentRequest request) {
        Student student = studentService.createStudent(request);
        return ResponseEntity.ok(student);

    }

    @GetMapping
    ResponseEntity<List<Student>> getStudents() {
        List<Student> studentResponses = studentService.getAllStudents();
        return ResponseEntity.ok(studentResponses);
    }
    
    @GetMapping("/{id}")
    StudentResponse getStudentById(@PathVariable UUID id) {
        return studentService.getStudentById(id);
        
    }
    
    @PutMapping("/update/{id}")
    StudentResponse updateStudent(@PathVariable UUID id, @RequestBody UpdateStudentRequest request) {
        return studentService.updateStudent(id, request);
    }
    
    @DeleteMapping("/{id}")
    String deleteStudent(@PathVariable UUID id) {
        studentService.deleteStudent(id);
        return "Student  has been deleted";
    }
    


}

