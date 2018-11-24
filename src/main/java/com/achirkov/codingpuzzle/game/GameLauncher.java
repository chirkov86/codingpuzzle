package com.achirkov.codingpuzzle.game;

import com.achirkov.codingpuzzle.io.ConsoleReader;
import com.achirkov.codingpuzzle.menus.menuitems.MenuOption;

public class GameLauncher {

    private static final String GAME_NAME = "RPG Game";

    private ConsoleReader consoleReader = new ConsoleReader();

    public void launchGame() {
        final GameContextManager gameContextManager = new GameContextManager();

        MenuOption command;
        while (gameContextManager.getGameState() != GameState.EXIT) {
            gameContextManager.showDialog();
            command = consoleReader.parseCommand(gameContextManager.getGameState());
            gameContextManager.processCommand(command);
        }
    }
}
