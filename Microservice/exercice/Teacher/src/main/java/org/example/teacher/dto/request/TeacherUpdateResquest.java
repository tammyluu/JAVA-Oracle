package org.example.teacher.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;


@FieldDefaults(level = AccessLevel.PRIVATE)
public class TeacherUpdateResquest {
    String firstName;
    String lastName;
    LocalDate dob;
    String subject;

    public TeacherUpdateResquest() {
    }

    public TeacherUpdateResquest(String firstName, String lastName, LocalDate dob, String subject) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.subject = subject;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
