package com.game;

import java.util.HashMap;

public class RoomExitsCollection {

    private HashMap<String, Room> Exits = new HashMap<String, Room>();

    public void addExit(String DirectionKey, Room Exit) {
        Exits.put(DirectionKey, Exit);
    }

    public Room getExitsByKey(String key) {
        return Exits.get(key);
    }

}
