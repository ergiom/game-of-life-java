package com.demo.ergiom.gameoflife.game;

import com.demo.ergiom.gameoflife.game.grid.Grid;
import com.demo.ergiom.gameoflife.game.grid.Node;
import com.demo.ergiom.gameoflife.game.grid.Position;
import com.demo.ergiom.gameoflife.game.roundcreator.ConstantSizeRoundCreator;
import com.demo.ergiom.gameoflife.game.roundcreator.RoundCreator;
import com.demo.ergiom.gameoflife.game.roundcreator.WrappedBordersRoundCreator;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class Game {
    private Grid grid;
    private RoundCreator roundCreator;

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

    public void setToggle(Position position) {
        if (grid.getValue(position) == Node.ALIVE) {
            setEmpty(position);
        } else {
            setAlive(position);
        }
    }

    public void setRoundCreator(RoundCreator roundCreator) {
        this.roundCreator = roundCreator;
    }

    @Override
    public String toString() {
        return grid.toString();
    }


    @Contract("_, _ -> new")
    public static @NotNull Game constantSizeGame(int height, int width) {
        return new Game(height, width, new ConstantSizeRoundCreator());
    }
    @Contract("_, _ -> new")
    public static @NotNull Game wrappedBordersGame(int width, int height) {
        return new Game(height, width, new WrappedBordersRoundCreator());
    }
}
