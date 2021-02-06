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
    public Command get_Command() {
        
        String inputLine;
        String firstInput = null;
        String secondInput = null;

        System.out.print("> ");

        inputLine = reader.nextLine();
        Scanner tokenizer = new Scanner(inputLine);

        if (tokenizer.hasNext()) {
            firstInput = tokenizer.next();
            if (tokenizer.hasNext()) {
                secondInput = tokenizer.next();
            }
        }

        if (commands.is_Command(firstInput)) {
            return new Command(firstInput, secondInput);
        } else {
            return new Command(null, secondInput);
        }
    }

}
