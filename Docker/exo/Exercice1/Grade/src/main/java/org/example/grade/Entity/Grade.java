package org.example.grade.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.grade.Dto.Student;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double note;
    private long studentId;
    private long subjectId;

    public Grade(double note, long studentId, long subjectId) {
        this.note = note;
        this.studentId = studentId;
        this.subjectId = subjectId;
    }
}
