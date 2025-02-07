package org.example.studentapi.mapper;

import org.example.studentapi.dto.request.StudentRequest;
import org.example.studentapi.dto.request.UpdateStudentRequest;
import org.example.studentapi.dto.response.StudentResponse;
import org.example.studentapi.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;


@Mapper(componentModel= "spring")
public interface  IStudentMapper {

    Student toStudent(StudentRequest request);
    StudentResponse toStudentResponse(Student student);
    void updateStudent(@MappingTarget Student student, UpdateStudentRequest request);


}
