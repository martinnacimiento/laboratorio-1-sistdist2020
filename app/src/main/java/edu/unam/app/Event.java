package edu.unam.app;

import com.google.gson.Gson;

public class Event {
    private long time;
    private String nameNode;
    private String hash;

    public Event(long time, String nameNode, String hash) {
        this.time = time;
        this.nameNode = nameNode;
        this.hash = hash;
    }

    public String toJson() {
        return new Gson().toJson(this);
    }

    public static Event fromJson(String json) {
        return new Gson().fromJson(json, Event.class);
    }
}