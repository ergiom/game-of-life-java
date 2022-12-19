package com.demo.ergiom.gameoflife.game.roundcreator;

import com.demo.ergiom.gameoflife.game.grid.Grid;

public abstract class RoundCreator {
    protected Grid grid;

    public abstract Grid create(Grid grid);
}
