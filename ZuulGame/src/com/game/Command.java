package com.game;

public class Command {

    private String commandWord;
    private String direction;

    public Command(String action, String direction) {
        commandWord = action;
        this.direction = direction;
    }

    public String getCommandWord() {
        return commandWord;
    }

    public String getDirection() {
        return direction;
    }

    public boolean isUnknown() {
        return (commandWord.equals(null));
    }

    public boolean hasDirection() {
        return (direction != null);
    }

}
