package org.example.gateway.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.gateway.dto.teacher.Teacher;
import org.example.gateway.dto.teacher.TeacherDtoRequest;
import org.example.gateway.tools.RestClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/teacher")
@RequiredArgsConstructor
public class TeacherController {
    ObjectMapper om;

    @GetMapping("/{id}")
    public ResponseEntity<Teacher> getTeacherById (@PathVariable("id") long id){
        RestClient<Teacher> teacherRestClient = new RestClient<>("Http://localhost:8082/api/teacher/"+id);
        return  ResponseEntity.ok(teacherRestClient.getRequest(Teacher.class));
    }

    @PostMapping
    public ResponseEntity<Teacher> postStudent (@RequestBody TeacherDtoRequest teacherDtoReceive) throws JsonProcessingException {
        RestClient<Teacher> teacherRestClient = new RestClient<>("Http://localhost:8082/api/teacher/");
        return  ResponseEntity.ok(teacherRestClient.postRequest(om.writeValueAsString(teacherDtoReceive), Teacher.class));
    }
}
