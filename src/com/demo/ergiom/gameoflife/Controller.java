package com.demo.ergiom.gameoflife;

import com.demo.ergiom.gameoflife.game.Game;
import com.demo.ergiom.gameoflife.game.GameFactory;
import com.demo.ergiom.gameoflife.game.inputparser.InputParser;

import java.io.IOException;

public class Controller {
    private Game game;
    private final InputParser parser;

    public Controller() {
        parser = new InputParser();
    }

    public void loop() throws IOException {
        while (true) {
            if (! execute()) break;
        }
    }

    private boolean execute() throws IOException {
        System.out.print(">> ");
        switch (parser.read()) {
            case EXIT:
                return false;
            case LIST_GAMES:
                listGames();
                break;
            case PLAY_ROUND:
                playRound();
                break;
            case SELECT_GAME:
                selectGame();
                break;
            case HELP:
                listCommands();
                break;
            default:
                unknownCommand();
        }

        return true;
    }

    private void unknownCommand() {
        System.out.println("Unknown command. Try again.");
        //todo
    }

    private void selectGame() {
        System.out.println();
        //todo
    }

    private void playRound() {
        game.playRound();
    }

    private void listGames() {
        GameFactory.listGames();
    }

    private void listCommands() {
        //todo
    }
}
