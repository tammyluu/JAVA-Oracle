package org.example.teacher.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.teacher.entity.Subject;
import org.example.teacher.entity.Teacher;
import org.example.teacher.repository.SubjectRepository;
import org.example.teacher.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SubjectService {
    @Autowired
    SubjectRepository subjectRepository;
    @Autowired
    TeacherRepository teacherRepository;

    public List<Subject> findAllSubjetsByTeacherId(UUID id) {
        return subjectRepository.findByTeacherId(id);
    }
    public Subject findSubjectById(UUID id) {
        return  subjectRepository.findById(id).orElseThrow(() -> new RuntimeException("No such subject"));
    }

    public Subject createSubject(Subject subject) {
        Teacher teacher = teacherRepository.findById(subject.getTeacher().getId())
                .orElseThrow(() -> new RuntimeException("Teacher not found"));

        subject.setTeacher(teacher);
        return subjectRepository.save(subject);
    }
    public void deleteSubject(UUID id) {
        subjectRepository.deleteById(id);

    }

}
