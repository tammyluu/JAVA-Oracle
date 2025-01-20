package org.example.exo1.exo5;

import java.util.UUID;

public class Task {
    private UUID uuid;
    private String description;
    private boolean completed;

    public Task() {
    }

    public Task(UUID uuid, String description, boolean completed) {
        this.uuid = uuid;
        this.description = description;
        this.completed = completed;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
