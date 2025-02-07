package org.example;

public class Event {
    private String description;
    private String action;
    private String result;

    public Event(String description, String action, String result) {
        this.description = description;
        this.action = action;
        this.result = result;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
