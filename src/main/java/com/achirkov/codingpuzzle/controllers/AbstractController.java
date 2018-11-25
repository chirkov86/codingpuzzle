package com.achirkov.codingpuzzle.controllers;

import com.achirkov.codingpuzzle.game.GameContextManager;
import com.achirkov.codingpuzzle.game.GameState;
import com.achirkov.codingpuzzle.logger.Logger;
import com.achirkov.codingpuzzle.menus.Menu;
import com.achirkov.codingpuzzle.menus.menuoptions.MenuOption;

public abstract class AbstractController implements StateController {

    private static final Logger LOGGER = Logger.getInstance();

    Menu menu;

    /**
     * Processes input as one of pre-defined menu options
     * if current {@code GameState} has a menu with options,
     * or a free form input otherwise (e.g. typing character name)
     */
    @Override
    public final GameState processInput(String input, GameContextManager gameContextManager) {
        if (menu.getPossibleOptionInputs() != null) {
            MenuOption menuOption = commandFrom(input, gameContextManager.getGameState());
            return processCommand(menuOption, gameContextManager);
        } else {
            LOGGER.debug("processing as a free form input");
            return processFreeFormInput(input, gameContextManager);
        }
    }

    public GameState processFreeFormInput(String input, GameContextManager gameContextManager) {
        LOGGER.debug("processFreeFormInput: feature not implemented");
        return GameState.TRAVEL;
    }

    public GameState processCommand(MenuOption input, GameContextManager gameContextManager) {
        LOGGER.debug("processCommand: feature not implemented");
        return GameState.TRAVEL;
    }

    /**
     * Mapping {@code String} input to one of the pre-defined menu options
     */
    private MenuOption commandFrom(String input, GameState gameState) {
        LOGGER.debug("Mapping input code " + input + " to command for state " + gameState.toString());
        return gameState.getStateMenu().getOptionFromInput(input);
    }

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

}
