package com.achirkov.codingpuzzle.controllers;

import com.achirkov.codingpuzzle.game.GameContextManager;
import com.achirkov.codingpuzzle.game.GameState;
import com.achirkov.codingpuzzle.logger.Logger;
import com.achirkov.codingpuzzle.menus.Menu;
import com.achirkov.codingpuzzle.menus.menuoptions.MenuOption;

public abstract class AbstractController implements StateController {

    private static final Logger LOGGER = Logger.getInstance();

    Menu menu;

    @Override
    public final GameState processInput(String input, GameContextManager gameContextManager) {
        if (menu.getPossibleOptionInputs() != null) {
            MenuOption menuOption = commandFrom(input, gameContextManager.getGameState());
            return processCommand(menuOption, gameContextManager);
        } else {
            System.out.println("processing as a free form input");
            return processFreeFormInput(input, gameContextManager);
        }
    }

    public GameState processFreeFormInput(String input, GameContextManager gameContextManager) {
        System.out.println("Feature not implemented 1");
        return GameState.TRAVEL;
    }

    public GameState processCommand(MenuOption input, GameContextManager gameContextManager) {
        System.out.println("Feature not implemented 2");
        return GameState.TRAVEL;
    };

    @Override
    public Menu getMenu() {
        return menu;
    }

    @Override
    public void showMenu(GameContextManager gameContextManager) {
        if (menu != null) {
            menu.show(gameContextManager);
        }
    }

    @Override
    public void showReport(GameContextManager gameContextManager) {
    }

    private MenuOption commandFrom(String input, GameState gameState) {
        LOGGER.debug("Mapping input code " + input + " to command for state " + gameState.toString());
        return gameState.getStateMenu().getOptionFromCode(input);
    }
}
