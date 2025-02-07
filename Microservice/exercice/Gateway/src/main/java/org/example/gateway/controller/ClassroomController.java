package org.example.gateway.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.gateway.dto.classroom.Classroom;
import org.example.gateway.dto.classroom.ClassroomDtoRequest;
import org.example.gateway.tools.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/classroom")
public class ClassroomController {
    @Autowired
    ObjectMapper om;

    @GetMapping("/{id}")
    public ResponseEntity<Classroom> getTeacherById (@PathVariable("id") String id){
        RestClient<Classroom> classroomRestClient = new RestClient<>("Http://localhost:8082/api/teacher/"+id);
        return  ResponseEntity.ok(classroomRestClient.getRequest(Classroom.class));
    }

    @PostMapping
    public ResponseEntity<Classroom> postStudent (@RequestBody ClassroomDtoRequest classroomDtoReceive) throws JsonProcessingException {
        RestClient<Classroom> classroomRestClient = new RestClient<>("Http://localhost:8082/api/classroom/");
        return  ResponseEntity.ok(classroomRestClient.postRequest(om.writeValueAsString(classroomDtoReceive), Classroom.class));
    }
}
