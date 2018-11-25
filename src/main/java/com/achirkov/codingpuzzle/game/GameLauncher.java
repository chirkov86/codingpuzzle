package com.achirkov.codingpuzzle.game;

import com.achirkov.codingpuzzle.gamesetting.GameSetting;
import com.achirkov.codingpuzzle.io.ConsoleReader;

public class GameLauncher {

    private ConsoleReader consoleReader = new ConsoleReader();

    /**
     * Here is an extension point to plugin new game settings
     */
    public void launchGame() {
        final GameContextManager gameContextManager = new GameContextManager(GameSetting.DUNGEON);
        //final GameContextManager gameContextManager = new GameContextManager(GameSetting.LOTR);

        String command;
        while (gameContextManager.getGameState() != GameState.EXIT) {
            gameContextManager.showDialog();
            command = consoleReader.parseCommand(gameContextManager.getGameState());
            gameContextManager.processInput(command);
        }
    }
}
