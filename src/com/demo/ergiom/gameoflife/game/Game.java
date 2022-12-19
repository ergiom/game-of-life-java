package com.demo.ergiom.gameoflife.game;

import com.demo.ergiom.gameoflife.game.grid.Grid;
import com.demo.ergiom.gameoflife.game.grid.Node;
import com.demo.ergiom.gameoflife.game.grid.Position;

public abstract class Game {
    public abstract void playRound();

    public void setEmpty(Position position) {
        getGrid().setValue(position, Node.EMPTY);
    }

    public void setAlive(Position position) {
        getGrid().setValue(position, Node.ALIVE);
    }

    abstract Grid getGrid();

    @Override
    public String toString() {
        return getGrid().toString();
    }
}
