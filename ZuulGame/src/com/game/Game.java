package com.game;

public class Game {
    
    private void main_View() {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println("You are " + currentRoom.get_Location());
        System.out.print("Exits: ");
        if (currentRoom.northExit != null) {
            System.out.print("north ");
        }
        if (currentRoom.eastExit != null) {
            System.out.print("east ");
        }
        if (currentRoom.southExit != null) {
            System.out.print("south ");
        }
        if (currentRoom.westExit != null) {
            System.out.print("west ");
        }
        System.out.println();
    }

    private void help_View() {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println("go quit help");
    }

    public Game() {
        build_Rooms();
        parser = new Parser();
    }

    private void build_Rooms() {
        Room outside, theatre, pub, lab, office;
        outside = new Room("outside the main entrance of the university");
        theatre = new Room("in a lecture theatre");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");
        outside.set_Exits(null, theatre, lab, pub);
        theatre.set_Exits(null, null, null, outside);
        pub.set_Exits(null, outside, null, null);
        lab.set_Exits(outside, office, null, null);
        office.set_Exits(null, null, null, lab);
        currentRoom = outside;
    }

    public void play_Game() {
        main_View();
        boolean finished = false;
        while (!finished) {
            Command command = parser.get_Command();
            finished = process_Command(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    private boolean process_Command(Command command) {
        boolean wantToQuit = false;
        if (command.is_Unknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }
        String commandWord = command.get_CommandWord();
        if (commandWord.equals("help")) {
            help_View();
        } else if (commandWord.equals("go")) {
            navigate(command);
        } else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }
        return wantToQuit;
    }

    private void navigate(Command command) {
        if (!command.has_Direction()) {
            System.out.println("Go where?");
            return;
        }
        String direction = command.get_Direction();
        Room nextRoom = null;
        if (direction.equals("north")) {
            nextRoom = currentRoom.northExit;
        }
        if (direction.equals("east")) {
            nextRoom = currentRoom.eastExit;
        }
        if (direction.equals("south")) {
            nextRoom = currentRoom.southExit;
        }
        if (direction.equals("west")) {
            nextRoom = currentRoom.westExit;
        }
        if (nextRoom == null) {
            System.out.println("There is no door!");
        } else {
            currentRoom = nextRoom;
            System.out.println("You are " + currentRoom.get_Location());
            System.out.print("Exits: ");
            if (currentRoom.northExit != null) {
                System.out.print("north ");
            }
            if (currentRoom.eastExit != null) {
                System.out.print("east ");
            }
            if (currentRoom.southExit != null) {
                System.out.print("south ");
            }
            if (currentRoom.westExit != null) {
                System.out.print("west ");
            }
            System.out.println();
        }
    }

    private boolean quit(Command command) {
        if (command.has_Direction()) {
            System.out.println("Quit what?");
            return false;
        } else {
            return true;
        }
    }

    private Parser parser;
    private Room currentRoom;
}
