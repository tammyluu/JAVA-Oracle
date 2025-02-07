package org.example.grade.Repository;

import org.example.grade.Entity.Grade;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeRepository extends CrudRepository<Grade,Long> {
}
