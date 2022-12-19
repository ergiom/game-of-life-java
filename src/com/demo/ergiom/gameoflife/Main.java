package com.demo.ergiom.gameoflife;

import com.demo.ergiom.gameoflife.game.Game;
import com.demo.ergiom.gameoflife.game.grid.Position;

public class Main {
    public static void main(String[] args) {
        Game game = Game.wrappedBordersGame(10, 10);

        game.setAlive(new Position(4, 1));
        game.setAlive(new Position(4, 2));
        game.setAlive(new Position(5, 0));
        game.setAlive(new Position(5, 1));
        game.setAlive(new Position(6, 1));

        System.out.println(game);
        System.out.println();

        game.playRound();

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
