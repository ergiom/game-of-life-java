package com.demo.ergiom.gameoflife.game.roundcreator;

import com.demo.ergiom.gameoflife.game.grid.Grid;
import com.demo.ergiom.gameoflife.game.grid.Node;
import com.demo.ergiom.gameoflife.game.grid.Position;

import java.util.LinkedList;
import java.util.List;

public class ConstantSizeRoundCreator extends RoundCreator {

    @Override
    public Grid create(Grid grid) {
        this.grid = grid;
        Grid newGrid = new Grid(grid);

        for (int row = 0; row < grid.getHeight(); row++) {
            for (int column = 0; column < grid.getWidth(); column++) {
                Position position = new Position(row, column);
                Node status = _getNewState(position);
                newGrid.setValue(position, status);
            }
        }

        return newGrid;
    }


    private List<Position> _neighbours(Position position) {
        List<Position> list = new LinkedList<>();

        for (int deltaRow = -1; deltaRow <= 1; deltaRow++) {
            for (int deltaColumn = -1; deltaColumn <= 1; deltaColumn++) {
                if (deltaRow == deltaColumn && deltaRow == 0) continue;

                Position neighbour = new Position(
                        position.getRow() + deltaRow,
                        position.getColumn() + deltaColumn);
                if (grid.onMap(neighbour)) list.add(neighbour);
            }
        }

        return list;
    }

    private Node _getNewState(Position position) {
        int neighbours = _countNeighbours(position);
        Node currentState = grid.getValue(position);

        if (currentState.isAlive()) {
            if (neighbours == 2 || neighbours == 3) return Node.ALIVE;
        }
        else {
            if (neighbours == 3) return Node.ALIVE;
        }

        if (currentState == Node.EMPTY) return Node.EMPTY;
        return Node.DEAD;
    }

    private int _countNeighbours(Position position) {
        List<Position> neighbours = _neighbours(position);

        int sum = 0;
        for (Position neighbour: neighbours) {
            if (! grid.onMap(neighbour)) continue;
            if (grid.getValue(neighbour).isAlive()) sum++;
        }

        return sum;
    }
}
