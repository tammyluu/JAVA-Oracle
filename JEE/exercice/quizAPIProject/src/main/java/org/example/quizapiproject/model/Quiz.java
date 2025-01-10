package org.example.quizapiproject.model;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;

public class Quiz {
    private Long id;
    private String title;
    private List<Question> questions = new ArrayList<>();

    public Quiz() {}

    public Quiz(Long id, String title) {
        this.id = id;
        this.title = title;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "Quiz { " +
                "|id " + id +
                "|title " + title + '\'' +
                "|questions " + questions +
                " }";
    }
}
