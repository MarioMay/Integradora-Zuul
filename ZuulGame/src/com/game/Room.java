package com.game;

public class Room {

    public String location;
    public Room northExit;
    public Room southExit;
    public Room eastExit;
    public Room westExit;

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

    
    /**
     * @param northExit The north exit.
     * @param eastExit The east east.
     * @param southExit The south exit.
     * @param westExit The west exit.
     * Define the exits of this room.  Every direction either leads
     * to another room or in case it's null, means there's no exit there.
     */
    public void setExits(Room north, Room east, Room south, Room west) {

        if (north != null) {
            northExit = north;
        }
        if (east != null) {
            eastExit = east;
        }
        if (south != null) {
            southExit = south;
        }
        if (west != null) {
            westExit = west;
        }
    }

}
