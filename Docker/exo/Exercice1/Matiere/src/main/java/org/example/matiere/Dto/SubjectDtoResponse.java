package org.example.matiere.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SubjectDtoResponse {
    private long id;
    private String name;
    private double coef;
}
