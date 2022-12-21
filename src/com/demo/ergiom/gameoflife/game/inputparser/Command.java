package com.demo.ergiom.gameoflife.game.inputparser;

public enum Command {
    LIST_GAMES("list games"),
    SELECT_GAME("select game"),
    PLAY_ROUND("play round"),
    EXIT("exit"),
    HELP("help"),
    DISPLAY("display"),
    SET("set"),
    NOT_ASSIGNED("");

    private final String commandString;

    Command(String commandString) {
        this.commandString = commandString;
    }

    public String getCommandString() {
        return commandString;
    }
}
