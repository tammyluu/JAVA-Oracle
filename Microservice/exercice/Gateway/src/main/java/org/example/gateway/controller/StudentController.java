package org.example.gateway.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.gateway.dto.student.Student;
import org.example.gateway.dto.student.StudentDtoRequest;
import org.example.gateway.tools.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/student")
public class StudentController {
    @Autowired
    ObjectMapper om;

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById (@PathVariable("id") long id){
        RestClient<Student> studentRestClient = new RestClient<>("Http://localhost:8081/api/student/"+id);
        return  ResponseEntity.ok(studentRestClient.getRequest(Student.class));
    }

    @PostMapping
    public ResponseEntity<Student> postStudent (@RequestBody StudentDtoRequest studentDtoReceive) throws JsonProcessingException {
        RestClient<Student> studentRestClient = new RestClient<>("Http://localhost:8081/api/student/");
        return  ResponseEntity.ok(studentRestClient.postRequest(om.writeValueAsString(studentDtoReceive), Student.class));
    }
}
