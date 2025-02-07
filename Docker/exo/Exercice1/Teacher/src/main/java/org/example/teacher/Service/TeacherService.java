package org.example.teacher.Service;

import org.example.teacher.Entity.Teacher;
import org.example.teacher.Repository.TeacherRepository;
import org.example.teacher.Tools.RestClient;
import org.example.teacher.dto.Subject;
import org.example.teacher.dto.TeacherDtoReceive;
import org.example.teacher.dto.TeacherDtoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TeacherService {

    @Autowired
    TeacherRepository teacherRepository;

    public TeacherDtoResponse save (TeacherDtoReceive teacherDtoReceive){
        Teacher student = dtoReceiveTOTeacher(teacherDtoReceive);
         teacherRepository.save(student);
        return teacherTODto(student);
    }

    public TeacherDtoResponse getById (long id){
        return  teacherTODto(teacherRepository.getReferenceById(id));
    }



    public Teacher dtoReceiveTOTeacher (TeacherDtoReceive teacherDtoReceive){
        return new Teacher(teacherDtoReceive.getFirstname(), teacherDtoReceive.getLastname(), LocalDate.parse(teacherDtoReceive.getBirthDateStr()), teacherDtoReceive.getSubjectId());
    }
    public TeacherDtoResponse teacherTODto (Teacher teacher){
        RestClient<Subject> subjectRestClient = new RestClient<>("http://localhost:8084/api/subject/"+teacher.getSubjectId());
        Subject subject = subjectRestClient.getRequest(Subject.class);
        return new TeacherDtoResponse(teacher.getId() ,teacher.getFirstname(),teacher.getLastname(), teacher.getBirthDate(),subject);
    }

}
