package com.achirkov.codingpuzzle.game;

import com.achirkov.codingpuzzle.io.ConsoleReader;

public class GameLauncher {

    private static final String GAME_NAME = "RPG Game";

    private ConsoleReader consoleReader = new ConsoleReader();

    public void launchGame() {
        final GameContextManager gameContextManager = new GameContextManager();

        String command;
        while (gameContextManager.getGameState() != GameState.EXIT) {
            gameContextManager.showDialog();
            command = consoleReader.parseCommand(gameContextManager.getGameState());
            gameContextManager.processInput(command);
        }
    }
}
