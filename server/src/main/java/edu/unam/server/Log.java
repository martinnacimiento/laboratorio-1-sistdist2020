package edu.unam.server;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Log {
    private List<Event> events;
    private String nameFileLog;

    public Log(String nameFileLog) {
        this.events = new ArrayList<Event>();
        this.nameFileLog = nameFileLog;
    }

    public synchronized void pushEvent(Event event) {
        this.events.add(event);
        FileWriter file;
        try {
            file = new FileWriter("./logs/" + this.nameFileLog, false);
            Gson jsonPretty = new GsonBuilder().setPrettyPrinting().create();
            String json = jsonPretty.toJson(this.events);
            file.write(json);
            file.flush();
            file.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}