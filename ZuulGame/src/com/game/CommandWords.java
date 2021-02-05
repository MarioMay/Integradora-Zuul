package com.game;

public class CommandWords {

    private static final String[] commands = { "go", "quit", "help" };

    public boolean is_Command(String aString) {
        for (int i = 0; i < commands.length; i++) {
            if (commands[i].equals(aString)) {
                return true;
            }
        }
        return false;
    }
    
}
