package com.achirkov.codingpuzzle.controllers;

import com.achirkov.codingpuzzle.game.GameContextManager;
import com.achirkov.codingpuzzle.game.GameState;
import com.achirkov.codingpuzzle.menus.ExitMenu;
import com.achirkov.codingpuzzle.menus.menuoptions.MenuOption;

import static com.achirkov.codingpuzzle.game.GameState.EXIT;

public class ExitMenuController extends AbstractController implements StateController {

    public ExitMenuController() {
        menu = new ExitMenu();
    }

    @Override
    public GameState processCommand(MenuOption command, GameContextManager gameContextManager) {
        return EXIT;
    }
}
