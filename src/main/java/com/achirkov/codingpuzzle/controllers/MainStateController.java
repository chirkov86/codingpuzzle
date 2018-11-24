package com.achirkov.codingpuzzle.controllers;

import com.achirkov.codingpuzzle.game.GameContextManager;
import com.achirkov.codingpuzzle.game.GameState;
import com.achirkov.codingpuzzle.menus.MainMenu;
import com.achirkov.codingpuzzle.menus.menuitems.MainMenuOptions;
import com.achirkov.codingpuzzle.menus.menuitems.MenuOption;

import static com.achirkov.codingpuzzle.game.GameState.*;

public class MainStateController extends AbstractStateController implements StateController {

    public MainStateController(String gameName) {
        this.menu = new MainMenu(gameName);
    }

    @Override
    public GameState processCommand(MenuOption command, GameContextManager gameContextManager) {

        switch ((MainMenuOptions) command) {
            case START_NEW_GAME:
                gameContextManager.init();
                return CHARACTER_SELECTION;
            case SAVE_GAME:
                return SAVE_GAME;
            case LOAD_GAME:
                return LOAD_GAME;
            case EXIT:
                System.out.println("Good buy!");
                return EXIT;
            default:
                return MAIN_MENU;
        }
    }
}
