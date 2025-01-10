package org.example.quizapiproject.model;

public class Option {
    private Long id;
    private String content;
    private boolean correct;
    public Option() {}
    public Option(Long id, String content, boolean correct) {
        this.id = id;
        this.content = content;
        this.correct = correct;
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

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }
}
