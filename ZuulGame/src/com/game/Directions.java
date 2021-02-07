package com.game;

public class Directions {

    private static final String NORTH = "north";
    private static final String SOUTH = "south";
    private static final String EAST = "east";
    private static final String WEST = "west";

    /**
     * Returns the directions available to navigate of a specific room
     * @param room Receives a object room (outside, lab, etc...)
     * @return directions
     */
    public String getExitDirections(Room room) {
        String directions = " ";

        if (room.getExitRoomByKey(NORTH) != null) {
            directions += NORTH + " ";
        }
        if (room.getExitRoomByKey(EAST) != null) {
            directions += EAST + " ";
        }
        if (room.getExitRoomByKey(SOUTH) != null) {
            directions += SOUTH + " ";
        }
        if (room.getExitRoomByKey(WEST) != null) {
            directions += WEST + " ";
        }

        return directions;
    }
}
