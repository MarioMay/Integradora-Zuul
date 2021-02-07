package com.game;

public class Game {

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
      
        System.out.println("\nWelcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.\n");
        System.out.println("You are " + currentRoom.getLocation());
        System.out.print("Exits: ");

       /** if (currentRoom.northExit != null) {
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
        }**/
        System.out.println();
    }

    
    /**
     * Print the text help when the user type "help".
     */
    private void helpScreen() {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.\n");
        System.out.println("Your command words are:");
        System.out.println("go quit help");
    }


    /**
     * Builds the location rooms with their exits and the message 
     * that will show  when the user gets in some of those locations.
     */
    private void buildRooms() {

        Room outside, theatre, pub, lab, office;

        outside = new Room("outside the main entrance of the university");
        theatre = new Room("in a lecture theatre");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");

        //outside.setExits(null, theatre, lab, pub);
       // theatre.setExits(null, null, null, outside);
       // pub.setExits(null, outside, null, null);
       // lab.setExits(outside, office, null, null);
       // office.setExits(null, null, null, lab);
        currentRoom = outside;
    }


    /**
     *  Main function of the game, this start and keep executing
     *  the game until the games is finished.
     */
    public void startGame() {
        gameStartScreen();
        boolean isGameFinished = false;

        while (!isGameFinished) {
            Command command = parser.getCommand();
            isGameFinished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }


    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) {
      
        boolean wantToQuit = false;
        String commandWord = command.getCommandWord();

        if (command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }
        
        if (commandWord.equals("help")) {
            helpScreen();
        } else if (commandWord.equals("go")) {
            navigate(command);
        } else if (commandWord.equals("quit")) {
            wantToQuit = quitGame(command);
        }
        return wantToQuit;
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
        if (direction.equals("north")) {
        //    nextRoom = currentRoom.northExit;
        }
        if (direction.equals("east")) {
          //  nextRoom = currentRoom.eastExit;
        }
        if (direction.equals("south")) {
          //  nextRoom = currentRoom.southExit;
        }
        if (direction.equals("west")) {
          //  nextRoom = currentRoom.westExit;
        }
        if (nextRoom == null) {
            System.out.println("There is no door!");
        } else {
            currentRoom = nextRoom;
            System.out.println("You are " + currentRoom.getLocation());
            System.out.print("Exits: ");
          //  if (currentRoom.northExit != null) {
                System.out.print("north ");
           // }
           // if (currentRoom.eastExit != null) {
                System.out.print("east ");
           // }
           // if (currentRoom.southExit != null) {
                System.out.print("south ");
           // }
            //if (currentRoom.westExit != null) {
                System.out.print("west ");
            //}
            System.out.println();
        }
    }


    /** 
     * Check if the user typed "Quit" and verify the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quitGame(Command command) {
        if (command.hasDirection()) {
            System.out.println("Quit what?");
            return false;
        } else {
            return true;
        }
    }

}
