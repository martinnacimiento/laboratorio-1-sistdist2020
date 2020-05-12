package edu.unam.server;

import com.google.gson.Gson;

public class Event {
    private long time;
    private String nameNode;
    private String hash;
    private long timeDelay;
    private int bandwidth;

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

    public long getTime() {
        return time;
    }

    public String getNameNode() {
        return nameNode;
    }

    public String getHash() {
        return hash;
    }

    public long getTimeDelay() {
        return timeDelay;
    }

    public void setTimeDelay(long timeArrival) {
        this.timeDelay = timeArrival - this.time;
    }

    public int getBandwidth() {
        return bandwidth;
    }

    public void setBandwidth(int bandwidth) {
        this.bandwidth = bandwidth;
    }

}