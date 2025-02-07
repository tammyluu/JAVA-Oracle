package org.example.gateway.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.gateway.Dto.Classroom.Classroom;
import org.example.gateway.Dto.Classroom.ClassroomDtoReceive;
import org.example.gateway.Dto.Teacher.Teacher;
import org.example.gateway.Tools.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/classromm")
public class ClassroomController {
    @Autowired
    ObjectMapper om;

    @GetMapping("/{id}")
    public ResponseEntity<Classroom> getTeacherById (@PathVariable("id") String id){
        RestClient<Classroom> classroomRestClient = new RestClient<>("Http://localhost:8082/api/teacher/"+id);
        return  ResponseEntity.ok(classroomRestClient.getRequest(Classroom.class));
    }

    @PostMapping
    public ResponseEntity<Classroom> postStudent (@RequestBody ClassroomDtoReceive classroomDtoReceive) throws JsonProcessingException {
        RestClient<Classroom> classroomRestClient = new RestClient<>("Http://localhost:8082/api/classroom/");
        return  ResponseEntity.ok(classroomRestClient.postRequest(om.writeValueAsString(classroomDtoReceive), Classroom.class));
    }
}
