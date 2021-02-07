package com.game;

public class Command {

    private String commandWord;
    private String direction;

    /**
     * @param action Is the first word of the command {go, quit, help}. 
     * @param direction The second word of the command {north, south, east, west}.
     */
    public Command(String action, String direction) {
        commandWord = action;
        this.direction = direction;
    }


    /**
     * Return the command word (the "action") of this command. If the
     * command was not understood, the result is null.
     * @return The command word.
     */
    public String getCommandWord() {
        return commandWord;
    }

     /**
     * @return The second word of the command (the "direction"). 
     *         Returns null if there was no second word.
     */
    public String getDirection() {
        return direction;
    }

     /**
     * Check if the command match with somo of the commands expected.
     * @return true if this command was not understood.
     */
    public boolean isUnknown() {
        return (commandWord == null);
    }
      
      
     /**
     * Checks if the command has the second parameter "direction"
     * @return true if the command has a "direction".
     */
    public boolean hasDirection() {
        return (direction != null);
    }

}
