package org.example.teacher.mapper;

import org.example.teacher.dto.request.TeacherRequest;
import org.example.teacher.dto.request.TeacherUpdateResquest;
import org.example.teacher.dto.response.TeacherResponse;
import org.example.teacher.entity.Teacher;
import org.mapstruct.Mapper;

import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TeacherMapper {


    Teacher toTeacher(TeacherRequest request);
    TeacherResponse toTeacherResponse(Teacher teacher);
    void updateTeacher(@MappingTarget Teacher teacher, TeacherUpdateResquest request);


}
