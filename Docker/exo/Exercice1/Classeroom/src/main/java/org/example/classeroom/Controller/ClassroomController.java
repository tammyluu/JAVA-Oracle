package org.example.classeroom.Controller;

import org.example.classeroom.Dto.ClassroomDtoReceive;
import org.example.classeroom.Dto.ClassroomDtoResponse;
import org.example.classeroom.Service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/classroom")
public class ClassroomController {

    @Autowired
    ClassroomService classroomService;

    @GetMapping("/{id}")
    public ResponseEntity<ClassroomDtoResponse> getById (@PathVariable("id") String id){
        return ResponseEntity.ok(classroomService.getById(id));
    }

    @PostMapping
    public ResponseEntity<ClassroomDtoResponse> getById (@RequestBody ClassroomDtoReceive classroomDtoReceive){
        return ResponseEntity.ok(classroomService.save(classroomDtoReceive));
    }
}
