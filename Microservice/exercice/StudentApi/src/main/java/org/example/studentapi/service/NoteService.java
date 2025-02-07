package org.example.studentapi.service;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.studentapi.entity.Note;
import org.example.studentapi.entity.Student;
import org.example.studentapi.repository.NoteRepository;
import org.example.studentapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class NoteService {
    @Autowired
    NoteRepository noteRepository;
    @Autowired
    StudentRepository studentRepository;

    public Note addNoteByStudentId (UUID studentId, Note note) {
        Student student = (Student) noteRepository.findByStudentId(note.getStudent().getId());
        note.setStudent(student);
        return noteRepository.save(note);
    }


}
