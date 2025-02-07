package org.example.classeroom.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("Classroom")
public class Classroom {
    @Id
    private String idClassroom;
    private List<Long> idStudents;
    private Long idTeacher;

    public Classroom(List<Long> idStudents, Long idTeacher) {
        this.idStudents = idStudents;
        this.idTeacher = idTeacher;
    }
}
