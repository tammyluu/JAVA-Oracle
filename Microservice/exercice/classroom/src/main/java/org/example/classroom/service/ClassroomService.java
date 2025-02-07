package org.example.classroom.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.classroom.dto.ClassroomDtoReceive;
import org.example.classroom.dto.ClassroomDtoResponse;
import org.example.classroom.dto.Student;
import org.example.classroom.dto.Teacher;
import org.example.classroom.entity.Classroom;
import org.example.classroom.repository.ClassroomRepository;
import org.example.classroom.tool.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ClassroomService {

    @Autowired
    ClassroomRepository classroomRepository;

    public ClassroomDtoResponse save (ClassroomDtoReceive classroomDtoReceive) {
        Classroom classroom = dtoToClassroom(classroomDtoReceive);
        classroomRepository.save(classroom);
        return classroomToDto(classroom);
    }

    public ClassroomDtoResponse getById (String id){
        return classroomToDto(classroomRepository.findById(id).orElse(null));
    }

    public Classroom  dtoToClassroom(ClassroomDtoReceive recieve) {
        return new Classroom(recieve.getIdStudents(),recieve.getIsTeacher());
    }
    public ClassroomDtoResponse classroomToDto (Classroom classroom){
        if(classroom == null){
            return null;
        }
        List<Student> students = new ArrayList<>();
        Teacher teacher = null;

        RestClient<Student> studentRestClient = new RestClient<>("http://localhost:8081/api/student/");
        for(UUID id : classroom.getIdStudents()){
            students.add(studentRestClient.getRequest(Student.class,id.toString()));
        }

        RestClient<Teacher> teacherRestClient = new RestClient<>("http://localhost:8082/api/teacher/");
        teacher = teacherRestClient.getRequest(Teacher.class,classroom.getIdTeacher().toString());

        return new ClassroomDtoResponse(classroom.getIdClass(),students,teacher);
    }
}
