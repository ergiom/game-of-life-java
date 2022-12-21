package com.demo.ergiom.gameoflife.game.inputparser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputParser {
    BufferedReader reader;

    public InputParser() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }


    public Command read() throws IOException {
        System.out.print(">> ");
        String line = reader.readLine();

        return _parse(line);
    }

    public int readInt(String prompt) throws IOException {
        System.out.print(prompt);
        String line = reader.readLine();

        return Integer.parseInt(line);
    }

    public static String commandHelp() {
        StringBuilder builder = new StringBuilder();
        for (Command command: Command.values()) {
            if (command.equals(Command.NOT_ASSIGNED)) continue;

            builder.append("* ").append(command.getCommandString()).append('\n');
        }

        return builder.toString();
    }


    private Command _parse(String line) {
        if (line == null) return Command.EXIT;

        for (Command command: Command.values()) {
            if (command.getCommandString().equalsIgnoreCase(line.trim())) return command;
        }

        return Command.NOT_ASSIGNED;
    }
}
