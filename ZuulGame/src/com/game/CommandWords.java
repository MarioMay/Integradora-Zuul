package com.game;

public class CommandWords {

    private static final String[] commands = {
            "go", "quit", "help"
    };

    /**
     * Check if the input of the user is a valid command. 
     * @return true if a given string is a valid command,
     *         false otherwise
     */
    public boolean is_Command(String aString) {
        for (String command : commands) {
            if (command.equals(aString)) {
                return true;
            }
        }
        return false;
    }
    
}
