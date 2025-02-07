package org.example.classroom.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("Classroom")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Classroom {
    String idClass;
    List<UUID> idStudents;
    List<UUID> idTeacher;

    public Classroom(List<UUID> idStudents, List<UUID> idTeacher) {
        this.idStudents = idStudents;
        this.idTeacher = idTeacher;
    }
}
