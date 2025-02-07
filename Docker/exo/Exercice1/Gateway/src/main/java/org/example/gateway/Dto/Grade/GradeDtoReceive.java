package org.example.gateway.Dto.Grade;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GradeDtoReceive {
    private double note;
    private long studentId;
    private long subjectId;
}
