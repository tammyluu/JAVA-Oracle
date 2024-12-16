package org.example.filtresservlet.model;

import java.util.Date;

public class Observation {
    private int id;
    private Astronomy object;
    private Date date;
    private String description;
    private String gpsPosition;
    private String username;

    public Observation(int id, Astronomy object, Date date, String description, String gpsPosition, String username) {
        this.id = id;
        this.object = object;
        this.date = date;
        this.description = description;
        this.gpsPosition = gpsPosition;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Astronomy getObject() {
        return object;
    }

    public void setObject(Astronomy object) {
        this.object = object;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGpsPosition() {
        return gpsPosition;
    }

    public void setGpsPosition(String gpsPosition) {
        this.gpsPosition = gpsPosition;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Observation|" +
                "id :" + id +
                "| object: " + object +
                "| date: " + date +
                "| description: " + description + '\'' +
                "| gpsPosition : " + gpsPosition + '\'' +
                "| username: " + username + '\'' +
                '|';
    }
    public void add(Observation observation) {
        observation.add(this);
    }


}
