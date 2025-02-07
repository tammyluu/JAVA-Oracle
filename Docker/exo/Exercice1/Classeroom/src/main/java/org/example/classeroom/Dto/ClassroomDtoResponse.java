package org.example.classeroom.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassroomDtoResponse {
    private String idClassroom;
    private List<Student> idStudents;
    private Teacher idTeacher;
}
