package org.example.teacher.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.teacher.dto.Subject;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstname;
    private String lastname;
    private LocalDate birthDate;
    private long subjectId;

    public Teacher(String firstname, String lastname, LocalDate birthDate,long subject) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthDate = birthDate;
        this.subjectId = subject;
    }
}
