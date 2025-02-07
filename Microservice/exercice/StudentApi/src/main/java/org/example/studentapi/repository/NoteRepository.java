package org.example.studentapi.repository;

import org.example.studentapi.entity.Note;
import org.example.studentapi.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface NoteRepository extends JpaRepository<Note, UUID> {

    List<Note> findByStudentId(UUID studentId);
}
