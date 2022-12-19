package com.demo.ergiom.gameoflife.game;

import com.demo.ergiom.gameoflife.game.grid.Grid;
import com.demo.ergiom.gameoflife.game.grid.Node;
import com.demo.ergiom.gameoflife.game.grid.Position;
import com.demo.ergiom.gameoflife.game.roundcreator.ConstantSizeRoundCreator;
import com.demo.ergiom.gameoflife.game.roundcreator.RoundCreator;
import com.demo.ergiom.gameoflife.game.roundcreator.WrappedBordersRoundCreator;

public class Game {
    private Grid grid;
    private final RoundCreator roundCreator;

    private Game(int height, int width, RoundCreator roundCreator) {
        this.grid = new Grid(height, width, Node.EMPTY);
        this.roundCreator = roundCreator;
    }

    public void playRound() {
        grid = roundCreator.create(grid);
    }

    public void setAlive(Position position) {
        grid.setValue(position, Node.ALIVE);
    }

    public void setEmpty(Position position) {
        grid.setValue(position, Node.EMPTY);
    }

    @Override
    public String toString() {
        return grid.toString();
    }


    public static Game constantSizeGame(int height, int width) {
        return new Game(height, width, new ConstantSizeRoundCreator());
    }
    public static Game wrappedBordersGame(int width, int height) {
        return new Game(height, width, new WrappedBordersRoundCreator());
    }
}
