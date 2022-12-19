package com.demo.ergiom.gameoflife.game;

public class GameFactory {
    public static Game createGame(int n, int height, int width) {
        GameType[] gameTypes = GameType.values();

        int index = n - 1;
        if (index < 0 || index > gameTypes.length) throw new RuntimeException("Invalid index");

        return gameTypes[index].getGameSupplier().apply(height, width);
    }

    public static String listGames() {
        StringBuilder builder = new StringBuilder();
        GameType[] gameTypes = GameType.values();

        for (int i = 1; i < gameTypes.length + 1; i++) {
            builder.append(i).append(" ").append(gameTypes[i - 1]).append("\n");
        }

        return builder.toString();
    }
}
