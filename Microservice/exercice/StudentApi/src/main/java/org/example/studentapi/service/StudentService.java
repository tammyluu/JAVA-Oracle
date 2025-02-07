package org.example.studentapi.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.studentapi.dto.request.StudentRequest;
import org.example.studentapi.dto.request.UpdateStudentRequest;
import org.example.studentapi.dto.response.StudentResponse;
import org.example.studentapi.entity.Student;
import org.example.studentapi.mapper.IStudentMapper;
import org.example.studentapi.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    IStudentMapper mapper;

    public Student createStudent(StudentRequest request) {
        Student student = mapper.toStudent(request);
        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setDob(LocalDate.parse(request.getDob()));
        return studentRepository.save(student);

    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

  /*  public StudentResponse setStudent (Student student) {
        return new StudentResponse(student.getFirstName(),student.getLastName());
    }
*/

    public StudentResponse getStudentById(UUID id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        return mapper.toStudentResponse(student);
    }


    public void deleteStudent(UUID id) {
        studentRepository.deleteById(id);
    }

    public  StudentResponse updateStudent(UUID id, UpdateStudentRequest req) {
        Student st = studentRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Student not found"));
        mapper.updateStudent(st,req);
        return mapper.toStudentResponse(studentRepository.save(st));

    }
}
