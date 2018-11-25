package com.achirkov.codingpuzzle.game;

import com.achirkov.codingpuzzle.gamesetting.GameSetting;
import com.achirkov.codingpuzzle.io.ConsoleReader;

public class GameLauncher {

    static final String GAME_NAME = "RPG Game";

    private ConsoleReader consoleReader = new ConsoleReader();

    public void launchGame() {
        final GameContextManager gameContextManager = new GameContextManager(GameSetting.DUNGEON);

        String command;
        while (gameContextManager.getGameState() != GameState.EXIT) {
            gameContextManager.showDialog();
            command = consoleReader.parseCommand(gameContextManager.getGameState());
            gameContextManager.processInput(command);
        }
    }
}
