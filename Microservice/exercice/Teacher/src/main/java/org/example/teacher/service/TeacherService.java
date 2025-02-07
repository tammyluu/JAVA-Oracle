package org.example.teacher.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.teacher.dto.request.TeacherRequest;
import org.example.teacher.dto.request.TeacherUpdateResquest;
import org.example.teacher.dto.response.TeacherResponse;
import org.example.teacher.entity.Teacher;
import org.example.teacher.mapper.TeacherMapper;
import org.example.teacher.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TeacherService {
    @Autowired
    TeacherRepository teacherRepository;
    @Autowired
    TeacherMapper teacherMapper;

    public Teacher createTeacher(TeacherRequest request) {
        Teacher teacher = teacherMapper.toTeacher(request);
        System.out.println("First Name: " + request.getFirstName());
        return teacherRepository.save(teacher);
    }
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public TeacherResponse getTeacherById(UUID id) {
        return teacherRepository.findById(id)
                .map(teacherMapper::toTeacherResponse)
                .orElse(null);
    }

    public TeacherResponse updateTeacher(UUID id, TeacherUpdateResquest request) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found"));
        teacherMapper.updateTeacher(teacher,request);
        return teacherMapper.toTeacherResponse(teacherRepository.save(teacher));
    }


}
