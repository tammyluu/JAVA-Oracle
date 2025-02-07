package org.example.gateway.Dto.Teacher;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TeacherDtoReceive {
    private String firstname;
    private String lastname;
    private String birthDateStr;
    private String subject;
}
