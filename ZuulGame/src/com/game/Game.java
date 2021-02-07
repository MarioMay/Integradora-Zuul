package com.game;

public class Game {

    private static final String NORTH = "north";
    private static final String SOUTH = "south";
    private static final String EAST = "east";
    private static final String WEST = "west";
    private static final String GO = "go";
    private static final String QUIT = "quit";
    private static final String HELP = "help";
    
    private Room currentRoom;
    private Parser parser;

    public Game() {
        buildRooms();
        parser = new Parser();
    }

    /**
     * Print the welcome when the game starts.
     */
    private void gameStartScreen() {
      
        System.out.println("\nWelcome to the World of Zuul!"
        +"\nWorld of Zuul is a new, incredibly boring adventure game."
        +"\nType 'help' if you need help.\n");
        System.out.println("You are " + currentRoom.getLocation()
        + "Exits: ");
        

        if (currentRoom.getExitRoomByKey(NORTH) != null) {
            System.out.print(NORTH + " ");
        }

        if (currentRoom.getExitRoomByKey(EAST) != null) {
            System.out.print(EAST + " ");
        }

        if (currentRoom.getExitRoomByKey(SOUTH) != null) {
            System.out.print(SOUTH + " ");
        }

        if (currentRoom.getExitRoomByKey(WEST) != null) {
            System.out.print(WEST + " ");
        }

        System.out.println();
    }

    
    /**
     * Print the text help when the user type "help".
     */
    private void helpScreen() {
        System.out.println("\nYou are lost. You are alone. You wander"
        +"\naround at the university.\n"
        +"\nYour command words are:"
        +"\n go quit help");
    }


    /**
     * Builds the location rooms with their exits and the message 
     * that will show  when the user gets in some of those locations.
     */
    private void buildRooms() {

        Room outside;
        Room theatre;
        Room pub;
        Room lab;
        Room office;

        outside = new Room("outside the main entrance of the university");
        theatre = new Room("in a lecture theatre");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");

        outside.addExit(EAST, theatre);
        outside.addExit(SOUTH, lab);
        outside.addExit(WEST, pub);
        theatre.addExit(WEST, outside);
        pub.addExit(EAST, outside);
        lab.addExit(NORTH, outside);
        lab.addExit(EAST, office);
        office.addExit(WEST, lab);

        currentRoom = outside;
    }


    /**
     *  Main function of the game, this start and keep executing
     *  the game until the games is finished.
     */
    public void startGame() {

        gameStartScreen();

        while (true) {
            Command command = parser.getCommand();
            processCommand(command);
        }
        
    }


    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     */
    private void processCommand(Command command) {
      
        String commandWord = command.getCommandWord();

        if (command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return;
        }
        
        if (commandWord.equals(HELP)) {
            helpScreen();
        } 
        
        if (commandWord.equals(GO)) {
            navigate(command);
        } 

        if (commandWord.equals(QUIT)) {
            quitGame();
        }
        
    }


    /** 
     * Let the user move into the rooms with the directions
     * that the user type. If there is an exit, enter
     * the new room, otherwise print an error message.
     */
    private void navigate(Command command) {
        if (!command.hasDirection()) {
            System.out.println("Go where?");
            return;
        }
        String direction = command.getDirection();
        Room nextRoom = null;

        nextRoom = currentRoom.getExitRoomByKey(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        } else {
            currentRoom = nextRoom;
            System.out.println("\nYou are " + currentRoom.getLocation());
            System.out.print("Exits: ");

            if (currentRoom.getExitRoomByKey(NORTH) != null) {
                System.out.print(NORTH + " ");
            }

            if (currentRoom.getExitRoomByKey(EAST) != null) {
                System.out.print(EAST + " ");
            }

            if (currentRoom.getExitRoomByKey(SOUTH) != null) {
                System.out.print(SOUTH + " ");
            }

            if (currentRoom.getExitRoomByKey(WEST) != null) {
                System.out.print(WEST + " ");
            }
            System.out.println("\n");
        }
    }


    /** 
     * Check if the user typed "Quit" and verify the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private void quitGame() {
        System.out.println("Thank you for playing. Good bye.");
        System.exit(0);
    }

}
