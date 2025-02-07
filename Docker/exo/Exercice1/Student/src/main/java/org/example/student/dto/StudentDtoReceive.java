package org.example.student.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentDtoReceive {
    private String firstname;
    private String lastname;
    private String birthDateStr;
}
