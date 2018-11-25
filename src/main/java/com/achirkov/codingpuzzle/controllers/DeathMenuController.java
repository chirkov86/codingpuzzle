package com.achirkov.codingpuzzle.controllers;

import com.achirkov.codingpuzzle.game.GameContextManager;
import com.achirkov.codingpuzzle.game.GameState;
import com.achirkov.codingpuzzle.menus.DeathMenu;
import com.achirkov.codingpuzzle.menus.menuoptions.MenuOption;

import static com.achirkov.codingpuzzle.game.GameState.MAIN_MENU;
import static com.achirkov.codingpuzzle.io.ColorCodes.ANSI_RED;
import static com.achirkov.codingpuzzle.io.ColorCodes.ANSI_RESET;

public class DeathMenuController extends AbstractController implements StateController {

    public DeathMenuController() {
        menu = new DeathMenu();
    }

    @Override
    public GameState processCommand(MenuOption command, GameContextManager gameContextManager) {
        System.out.println(new StringBuilder().append(ANSI_RED)
                .append("\n Hero is dead and his adventure is over! You may start a new adventure\n")
                .append(ANSI_RESET));
        return MAIN_MENU;
    }
}
