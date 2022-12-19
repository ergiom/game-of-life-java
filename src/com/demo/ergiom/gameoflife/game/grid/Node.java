package com.demo.ergiom.gameoflife.game.grid;

public enum Node {
    EMPTY(false, '.'), ALIVE(true, '#'), DEAD(false, '.');

    private final boolean alive;
    private final char symbol;

    Node(boolean alive, char symbol) {
        this.alive = alive;
        this.symbol = symbol;
    }

    public boolean isAlive() {
        return alive;
    }

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }
}
