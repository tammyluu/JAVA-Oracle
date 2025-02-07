package org.example.gateway.dto.classroom;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.gateway.dto.student.Student;
import org.example.gateway.dto.teacher.Teacher;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Classroom {
    String idClass;
    List<Student> idStudents;
    Teacher idTeacher;
}
