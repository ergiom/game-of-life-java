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
        if (line.equals("list games")) {
            return Command.LIST_GAMES;
        }
        //todo
        return null;
    }
}
