package org.example.teacher.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TeacherDtoResponse {
    private long id;
    private String firstname;
    private String lastname;
    private LocalDate birthDate;
    private Subject subject;
}
