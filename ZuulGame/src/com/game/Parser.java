package com.game;

import java.util.Scanner;

public class Parser {

    public Parser() {
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }

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

    private CommandWords commands;
    private Scanner reader;

}
