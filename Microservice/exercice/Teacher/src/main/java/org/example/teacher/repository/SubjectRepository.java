package org.example.teacher.repository;

import org.example.teacher.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface SubjectRepository extends JpaRepository<Subject, UUID> {

    List<Subject> findByTeacherId(UUID teacherId);
}
