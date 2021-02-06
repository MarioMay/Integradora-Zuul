package com.game;

public class CommandWords {

    private static final String[] commands = {
            "go", "quit", "help"
    };

    public boolean isCommand(String aString) {
        for (String command : commands) {
            if (command.equals(aString)) {
                return true;
            }
        }
        return false;
    }
    
}
