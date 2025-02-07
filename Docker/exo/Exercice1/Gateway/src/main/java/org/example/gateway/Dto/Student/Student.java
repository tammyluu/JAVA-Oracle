package org.example.gateway.Dto.Student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {
    private long id;
    private String firstname;
    private String lastname;
    private LocalDate birthDate;
}
