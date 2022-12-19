package com.demo.ergiom.gameoflife.game;

import java.util.function.BiFunction;

public enum GameType {
    CONSTANT_SIZE(Game::constantSizeGame), WRAPPED_BORDERS(Game::wrappedBordersGame);

    private final BiFunction<Integer, Integer, Game> gameSupplier;
    GameType(BiFunction<Integer, Integer, Game> gameSupplier) {
        this.gameSupplier = gameSupplier;
    }

    public BiFunction<Integer, Integer, Game> getGameSupplier() {
        return gameSupplier;
    }
}
