package com.game;

public class Room {

    public String location;
    public Room northExit;
    public Room southExit;
    public Room eastExit;
    public Room westExit;

    public Room(String location) {
        this.location = location;
    }

    public String get_Location() {
        return location;
    }

    public void set_Exits(Room north, Room east, Room south, Room west) {
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
