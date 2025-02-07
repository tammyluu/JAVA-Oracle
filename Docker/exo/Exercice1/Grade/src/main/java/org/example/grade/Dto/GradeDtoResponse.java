package org.example.grade.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GradeDtoResponse {
    private long id;
    private double note;
    private Student student;
    private Subject subject;
}
