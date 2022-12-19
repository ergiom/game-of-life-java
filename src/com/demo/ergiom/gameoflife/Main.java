package com.demo.ergiom.gameoflife;

import com.demo.ergiom.gameoflife.game.ConstantSizeGame;
import com.demo.ergiom.gameoflife.game.Game;
import com.demo.ergiom.gameoflife.game.grid.Position;

public class Main {
    public static void main(String[] args) {
        Game game = new ConstantSizeGame(10, 10);

        game.setAlive(new Position(4, 4));
        game.setAlive(new Position(4, 5));
        game.setAlive(new Position(5, 3));
        game.setAlive(new Position(5, 4));
        game.setAlive(new Position(6, 4));

        System.out.println(game);
        System.out.println();

        game.playRound();

        System.out.println(game);
        System.out.println();

        game.playRound();

        System.out.println(game);
        System.out.println();
    }
}
