package com.achirkov.codingpuzzle.controllers;

import com.achirkov.codingpuzzle.exceptions.SaveGameNotFoundException;
import com.achirkov.codingpuzzle.game.GameContextManager;
import com.achirkov.codingpuzzle.game.GameState;
import com.achirkov.codingpuzzle.menus.MainMenu;
import com.achirkov.codingpuzzle.menus.menuoptions.MainMenuOptions;
import com.achirkov.codingpuzzle.menus.menuoptions.MenuOption;

import static com.achirkov.codingpuzzle.game.GameState.*;
import static com.achirkov.codingpuzzle.io.ColorCodes.ANSI_RED;
import static com.achirkov.codingpuzzle.io.ColorCodes.ANSI_RESET;

public class MainMenuController extends AbstractController {

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
                return save(gameContextManager);
            case RESUME_GAME:
                return contextAwareResume(gameContextManager);
            case EXIT:
                System.out.println("Good buy!");
                return EXIT;
            default:
                return MAIN_MENU;
        }
    }

    private GameState save(GameContextManager gameContextManager) {
        if (gameContextManager.getPlayer() != null && gameContextManager.getPlayer().isAlive()) {
            gameContextManager.save();
            System.out.println("Game saved!");
            return TRAVEL;
        } else {
            System.out.println(ANSI_RED + "\n Nothing to save! You may start a new adventure\n" + ANSI_RESET);
            return MAIN_MENU;
        }
    }

    /**
     * Resume option is context dependent:
     * <li>It resumes Travel Map if player is on Travel and is alive</li>
     * <li>It resumes saved game if player has not started a new game yet</li>
     * <li>It suggests to start a new game if no savegame is found and if player has not started a new game yet</li>
     */
    private GameState contextAwareResume(GameContextManager gameContextManager) {
        if (gameContextManager.getPlayer() != null)
            if (gameContextManager.getPlayer().isAlive()) {
                return TRAVEL;
            } else {
                System.out.println(new StringBuilder().append(ANSI_RED)
                        .append("\n Hero is dead and his adventure is over! You may start a new adventure\n")
                        .append(ANSI_RESET));
                return MAIN_MENU;
            }
        else {
            try {
                gameContextManager.load();
                return TRAVEL;
            } catch (SaveGameNotFoundException e) {
                System.out.println(new StringBuilder().append(ANSI_RED)
                        .append("\n Saved game not found! You may start a new adventure\n")
                        .append(ANSI_RESET).toString());
                return MAIN_MENU;
            }
        }
    }
}
