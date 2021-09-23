package com.tec.mathsockets.network;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;

import java.io.File;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.HashMap;
import java.util.List;

public class EventManager {

    HashMap<String, List<EventListener>> listeners = new HashMap<>();

    public static Json json = new Json();
    public static FileHandle files = Gdx.files.local("text/request.json");

    public EventManager(String... operations) {
        for (String operation: operations) {
            this.listeners.put(operation, new ArrayList<EventListener>());
        }
    }

    public void subscribe(String eventType, EventListener listener) {
        List<EventListener> users = listeners.get(eventType);
        users.add(listener);
    }

    public void unsubscribe(String eventType, EventListener listener) {
        List<EventListener> users = listeners.get(eventType);
        users.remove(listener);
    }

    public void notify(String eventType, File file) {
        List<EventListener> users = listeners.get(eventType);
        for (EventListener listener : users) {
            //listener.update(eventType, file);
        }
    }
}
