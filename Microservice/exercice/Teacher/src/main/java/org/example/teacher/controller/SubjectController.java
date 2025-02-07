package org.example.teacher.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.teacher.entity.Subject;
import org.example.teacher.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/subject")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SubjectController {
    @Autowired
    SubjectService subjectService;

    @PostMapping
    public Subject createSubject(@RequestBody Subject subject) {
        return subjectService.createSubject(subject);
    }

    @GetMapping("/teacher/{id}")
    public List<Subject> getSubjecstByTeacherId(@PathVariable UUID id) {
        return subjectService.findAllSubjetsByTeacherId(id);
    }

    @GetMapping("/{id}")
    public Subject getSubjectById(@PathVariable UUID id) {
        return subjectService.findSubjectById(id);
    }


    @DeleteMapping("/{id}")
    public void deleteSubject(@PathVariable UUID id) {
        subjectService.deleteSubject(id);
    }

}
