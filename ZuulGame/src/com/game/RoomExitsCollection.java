package com.game;

import java.util.HashMap;

public class RoomExitsCollection {

    private HashMap<String, Room> Exists = new HashMap<String, Room>();

    public void addExit(String DirectionKey, Room Exit) {
        Exists.put(DirectionKey, Exit);
    }

    public Room getExitsByKey(String key) {
        return Exists.get(key);
    }

}
