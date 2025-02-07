package org.example.gateway.Dto.Classroom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassroomDtoReceive {
    private List<Long> idStudents;
    private Long idTeacher;
}
