package com.demo.ergiom.gameoflife.game.grid;

import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.List;

public class Grid {
    private final List<List<Node>> list;
    private final Node defaultNode;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (List<Node> row: list) {
            for (Node node: row) {
                builder.append(node);
            }
            builder.append('\n');
        }

        return builder.toString();
    }

    public Grid(@NotNull Grid grid) {
        this.list = new LinkedList<>();
        this.defaultNode = grid.getDefaultValue();
        _expandTo(grid.getHeight(), grid.getWidth());
    }

    public Grid(int height, int width, Node defaultNode) {
        this.list = new LinkedList<>();
        this.defaultNode = defaultNode;
        _expandTo(height, width);
    }

    public int getHeight() {
        return _getHeight();
    }

    public int getWidth() {
        return _getWidth();
    }

    public boolean onMap(@NotNull Position position) {
        return _onMap(position.getRow(), position.getColumn());
    }

    public void setValue(@NotNull Position position, Node value) {
        int row = position.getRow();
        int column = position.getColumn();

        _setValue(row, column, value);
    }

    public Node getValue(@NotNull Position position) {
        int row = position.getRow();
        int column = position.getColumn();

        return _getValue(row, column);
    }

    public Node getDefaultValue() {
        return defaultNode;
    }

    private void _expandTo(int row, int column) {
        while (row >= getHeight()) {
            _appendRow();
        }

        while (column >= getWidth()) {
            _appendColumn();
        }
    }

    private void _appendRow() {
        _insertRow(_getHeight());
    }

    private void _appendColumn() {
        _insertColumn(_getWidth());
    }

    private void _insertColumn(int index) {
        if (index > _getWidth()) throw new RuntimeException("Specified index is outside the grid");

        for (List<Node> row: list) {
            row.add(index, defaultNode);
        }
    }

    private void _insertRow(int index) {
        if (index > _getHeight()) throw new RuntimeException("Specified index is outside the grid");
        List<Node> newRow = new LinkedList<>();

        for (int i = 0; i < _getWidth(); i++) {
            newRow.add(defaultNode);
        }

        list.add(index ,newRow);
    }

    private boolean _onMap(int row, int column) {
        if (row < 0 || row >= _getHeight()) return false;
        if (column < 0 || column >= _getWidth()) return false;
        return true;
    }

    private void _setValue(int row, int column, Node value) {
        if (! _onMap(row, column)) throw new RuntimeException("Specified position is not on the grid");

        list.get(row).set(column, value);
    }

    private Node _getValue(int row, int column) {
        if (! _onMap(row, column)) throw new RuntimeException("Specified position is not on the grid");

        return list.get(row).get(column);
    }

    private int _getHeight() {
        return list.size();
    }

    private int _getWidth() {
        if (list.size() == 0) return 0;
        return list.get(0).size();
    }
}
