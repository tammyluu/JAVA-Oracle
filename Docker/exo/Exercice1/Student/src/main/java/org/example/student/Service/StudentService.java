package org.example.student.Service;

import org.example.student.Entity.Student;
import org.example.student.Repository.StudentRepository;
import org.example.student.dto.StudentDtoReceive;
import org.example.student.dto.StudentDtoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public StudentDtoResponse save (StudentDtoReceive studentDtoReceive){
        Student student = dtoReceiveTOStudent(studentDtoReceive);
         studentRepository.save(student);
        return studentTODto(student);
    }

    public StudentDtoResponse getById (long id){
        return  studentTODto(studentRepository.getReferenceById(id));
    }



    public Student dtoReceiveTOStudent (StudentDtoReceive studentDtoReceive){
        return new Student(studentDtoReceive.getFirstname(), studentDtoReceive.getLastname(), LocalDate.parse(studentDtoReceive.getBirthDateStr()));
    }
    public StudentDtoResponse studentTODto (Student student){
        return new StudentDtoResponse(student.getId() ,student.getFirstname(),student.getLastname(), student.getBirthDate());
    }

}
