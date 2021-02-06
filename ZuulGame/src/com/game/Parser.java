package com.game;

import java.util.Scanner;

public class Parser {

    private CommandWords commands;
    private Scanner reader;

    public Parser() {
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }


    /**
     * @return The next command from the user.
     */
    public Command getCommand() {
        String inputLine;
        String actionInput = null;
        String locationInput = null;

        System.out.print(">> ");
        inputLine = reader.nextLine();
        
        Scanner tokenizer = new Scanner(inputLine);

        if (tokenizer.hasNext()) {
            actionInput = tokenizer.next();
            if (tokenizer.hasNext()) {
                locationInput = tokenizer.next();
            }
        }

        if (commands.isCommand(actionInput)) {
            return new Command(actionInput, locationInput);
        } else {
            return new Command(null, locationInput);
        }
    }

}
