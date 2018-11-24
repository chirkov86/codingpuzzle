package com.achirkov.codingpuzzle.controllers;

import com.achirkov.codingpuzzle.game.GameContextManager;
import com.achirkov.codingpuzzle.game.GameState;
import com.achirkov.codingpuzzle.menus.MainMenu;
import com.achirkov.codingpuzzle.menus.menuitems.MainMenuOptions;
import com.achirkov.codingpuzzle.menus.menuitems.MenuOption;

import static com.achirkov.codingpuzzle.game.GameState.*;

public class MainMenuController extends AbstractController implements StateController {

    public MainMenuController(String gameName) {
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
            case RESUME_GAME:
                return contextAwareResume(gameContextManager);
            case EXIT:
                System.out.println("Good buy!");
                return EXIT;
            default:
                return MAIN_MENU;
        }
    }

    /**
     * Resume option is context dependent:
     * <li>It resumes Travel Map if player is on Travel</li>
     * <li>It resumes saved game if player has not started a new game yet</li>
     */
    private GameState contextAwareResume(GameContextManager gameContextManager) {
        if (gameContextManager.getPlayer() != null)
            return TRAVEL;
        else return MAIN_MENU;
    }
}
