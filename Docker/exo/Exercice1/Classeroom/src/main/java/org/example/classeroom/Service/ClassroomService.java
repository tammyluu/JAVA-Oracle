package org.example.classeroom.Service;

import org.example.classeroom.Dto.ClassroomDtoReceive;
import org.example.classeroom.Dto.ClassroomDtoResponse;
import org.example.classeroom.Dto.Student;
import org.example.classeroom.Dto.Teacher;
import org.example.classeroom.Entity.Classroom;
import org.example.classeroom.Repository.ClassroomRepository;
import org.example.classeroom.Tools.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassroomService {

    @Autowired
    ClassroomRepository classroomRepository;

    public ClassroomDtoResponse save (ClassroomDtoReceive classroomDtoReceive){
        Classroom classroom = dtoToClassroom(classroomDtoReceive);
        classroomRepository.save(classroom);
        return classroomToDto(classroom);
    }

    public ClassroomDtoResponse getById (String id){
        return classroomToDto(classroomRepository.findById(id).orElse(null));
    }

    public Classroom dtoToClassroom (ClassroomDtoReceive classroomDtoReceive){
        return new Classroom(classroomDtoReceive.getIdStudents(),classroomDtoReceive.getIdTeacher());
    }

    public ClassroomDtoResponse classroomToDto (Classroom classroom){
        if(classroom == null){
            return null;
        }
        List<Student> students = new ArrayList<>();
        Teacher teacher = null;

        RestClient<Student> studentRestClient = new RestClient<>("http://localhost:8081/api/student/");
        for(Long id : classroom.getIdStudents()){
            students.add(studentRestClient.getRequest(Student.class,id.toString()));
        }

        RestClient<Teacher> teacherRestClient = new RestClient<>("http://localhost:8082/api/teacher/");
        teacher = teacherRestClient.getRequest(Teacher.class,classroom.getIdTeacher().toString());

        return new ClassroomDtoResponse(classroom.getIdClassroom(),students,teacher);
    }
}
