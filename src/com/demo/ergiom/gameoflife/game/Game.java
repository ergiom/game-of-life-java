package com.demo.ergiom.gameoflife.game;

import com.demo.ergiom.gameoflife.game.grid.Position;

public abstract class Game {
    public abstract void playRound();

    public abstract void setEmpty(Position position);

    public abstract void setAlive(Position position);
}
