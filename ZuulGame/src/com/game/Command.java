package com.game;

public class Command {

    public Command(String action, String direction) {
        commandWord = action;
        this.direction = direction;
    }

    public String get_CommandWord() {
        return commandWord;
    }

    public String get_Direction() {
        return direction;
    }

    public boolean is_Unknown() {
        return (commandWord == null);
    }

    public boolean has_Direction() {
        return (direction != null);
    }

    private String commandWord;
    private String direction;

}
