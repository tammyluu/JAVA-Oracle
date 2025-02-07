package org.example.student.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentDtoResponse {
    private long id;
    private String firstname;
    private String lastname;
    private LocalDate birthDate;
}
