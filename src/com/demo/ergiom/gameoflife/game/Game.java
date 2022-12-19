package com.demo.ergiom.gameoflife.game;

import com.demo.ergiom.gameoflife.game.grid.Grid;
import com.demo.ergiom.gameoflife.game.grid.Node;
import com.demo.ergiom.gameoflife.game.grid.Position;

import java.util.LinkedList;
import java.util.List;

public class Game {
    private Grid grid;

    public Game(Grid grid) {
        this.grid = grid;
    }

    public Game() {
        this.grid = new Grid();
    }

    public Game(int height, int width) {
        grid = new Grid(height, width, Node.EMPTY);
    }

    public void playRound() {
        _playRound();
    }

    public void setEmpty(Position position) {
        _setValue(position, Node.EMPTY);
    }

    public void setAlive(Position position) {
        _setValue(position, Node.ALIVE);
    }

    @Override
    public String toString() {
        return grid.toString();
    }

    private void _setValue(Position position, Node state) {
        grid.setValue(position, state);
    }

    private List<Position> _neighbours(Position position) {
        List<Position> list = new LinkedList<>();

        for (int deltaRow = -1; deltaRow <= 1; deltaRow++) {
            for (int deltaColumn = -1; deltaColumn <= 1; deltaColumn++) {
                if (deltaRow == deltaColumn && deltaRow == 0) continue;

                Position neighbour = new Position(
                        position.getRow() + deltaRow,
                        position.getColumn() + deltaColumn);
                if (grid.onMap(position)) list.add(neighbour);
            }
        }

        return list;
    }

    private void _playRound() {
        Grid newGrid = new Grid(grid.getHeight(), grid.getWidth(), Node.EMPTY);

        for (int row = 0; row < grid.getHeight(); row++) {
            for (int column = 0; column < grid.getWidth(); column++) {
                Position position = new Position(row, column);
                Node status = _getNewState(position);
                newGrid.setValue(position, status);
            }
        }

        grid = newGrid;
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
