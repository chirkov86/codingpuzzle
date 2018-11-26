package com.achirkov.codingpuzzle.game;

import com.achirkov.codingpuzzle.gamesetting.GameSetting;
import com.achirkov.codingpuzzle.io.ConsoleReader;

public class GameLauncher {

    private ConsoleReader consoleReader;
    private GameContextManager gameContextManager;

    /**
     * Here is an extension point to plugin new game topic
     * TODO add CLI args support to switch game topic
     */
    public GameLauncher() {
        this.consoleReader = new ConsoleReader();

        // Here is how a new game topic enabled
        gameContextManager = new GameContextManager(GameSetting.DUNGEON);
        //gameContextManager = new GameContextManager(GameSetting.LOTR);
    }

    public void launchGame() {
        String command;
        while (gameContextManager.getGameState() != GameState.EXIT) {
            gameContextManager.showDialog();
            command = consoleReader.parseCommand(gameContextManager.getGameState());
            gameContextManager.processInput(command);
        }
    }
}
