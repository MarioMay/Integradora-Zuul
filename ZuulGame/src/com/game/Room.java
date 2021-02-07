package com.game;

public class Room {

    private String location;
    private RoomExitsCollection Exits = new RoomExitsCollection();

    /**
     * Create a room based in "location". Initially, it has
     * no exits. "location" is something like "a kitchen" or
     * "an open court yard".
     * @param location The room's location.
     */
    public Room(String location) {
        this.location = location;
    }


     /**
     * @return The location of the room.
     */
    public String getLocation() {
        return location;
    }


    public void addExit(String key, Room room) {
        Exits.addExit(key, room);
    }


    public Room getExitRoomByKey(String key) {
        return Exits.getExitsByKey(key);
    }

}
