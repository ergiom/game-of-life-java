package com.demo.ergiom.gameoflife;

import com.demo.ergiom.gameoflife.game.Game;
import com.demo.ergiom.gameoflife.game.GameFactory;
import com.demo.ergiom.gameoflife.game.grid.Position;
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
            case DISPLAY:
                display();
                break;
            case SET:
                setValue();
                break;
            default:
                unknownCommand();
        }

        return true;
    }

    private void setValue() throws IOException {
        if (! _gameReady()) return;

        int row = parser.readInt("Row = ");
        int column = parser.readInt("Column = ");

        game.setToggle(new Position(row, column));
    }

    private void display() {
        if (! _gameReady()) return;
        System.out.println(game);
    }

    private void unknownCommand() {
        System.out.println("Unknown command. Try again.");
    }

    private void selectGame() {
        int n;
        int height;
        int width;

        try {
            n = parser.readInt("Type = ");
            height = parser.readInt("Height = ");
            width = parser.readInt("Width = ");
        }
        catch (Exception e) {
            System.out.println("Invalid input");
            return;
        }

        game = GameFactory.createGame(n, height, width);
    }

    private void playRound() {
        if (! _gameReady()) return;
        game.playRound();
    }

    private void listGames() {
        System.out.println(GameFactory.listGames());
    }

    private void listCommands() {
        System.out.println(InputParser.commandHelp());
    }

    private boolean _gameReady() {
        if (game == null) {
            System.out.println("Game has not been initialized!");
            return false;
        }

        return true;
    }
}
