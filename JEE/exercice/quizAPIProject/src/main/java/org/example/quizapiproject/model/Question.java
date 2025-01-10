package org.example.quizapiproject.model;

import java.util.ArrayList;
import java.util.List;

public class Question{
    private Long id;
    private  String content;
    private List<Option> options = new ArrayList<>();

    public Question() {}
    public Question(Long id, String content) {
        this.id = id;
        this.content = content;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

   /* @Override
    public String toString() {
        return "Question { " +
                "|id " + id +
                "|content " + content + '\'' +
                "|options " + options +
                "}";
    }*/
}
