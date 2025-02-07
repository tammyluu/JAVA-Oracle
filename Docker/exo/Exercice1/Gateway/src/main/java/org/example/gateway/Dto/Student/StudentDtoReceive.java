package org.example.gateway.Dto.Student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentDtoReceive {
    private String firstname;
    private String lastname;
    private String birthDateStr;
}
