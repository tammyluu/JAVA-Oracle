package org.example.gateway.Dto.Classroom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.gateway.Dto.Student.Student;
import org.example.gateway.Dto.Teacher.Teacher;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Classroom {
    private String idClassroom;
    private List<Student> idStudents;
    private Teacher idTeacher;
}
