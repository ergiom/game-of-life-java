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
        String line = reader.readLine();

        return _parse(line);
    }

    public int readInt() throws IOException {
        String line = reader.readLine();

        return Integer.parseInt(line);
    }


    private Command _parse(String line) {
        if (line == null || line.equalsIgnoreCase("exit")) {
            return Command.EXIT;
        }

        if (line.equalsIgnoreCase("list games")) {
            return Command.LIST_GAMES;
        }

        if (line.equalsIgnoreCase("select game")) {
            return Command.SELECT_GAME;
        }

        if (line.equalsIgnoreCase("play round")) {
            return Command.PLAY_ROUND;
        }

        if (line.equalsIgnoreCase("help")) {
            return Command.HELP;
        }

        return null;
    }
}
