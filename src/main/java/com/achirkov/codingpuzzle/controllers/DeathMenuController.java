package com.achirkov.codingpuzzle.controllers;

import com.achirkov.codingpuzzle.game.GameContextManager;
import com.achirkov.codingpuzzle.game.GameState;
import com.achirkov.codingpuzzle.menus.DeathMenu;
import com.achirkov.codingpuzzle.menus.menuitems.MenuOption;

import static com.achirkov.codingpuzzle.game.GameState.MAIN_MENU;

public class DeathMenuController extends AbstractController implements StateController {

    public DeathMenuController() {
            this.menu = new DeathMenu();
    }


    @Override
    public GameState processCommand(MenuOption command, GameContextManager gameContextManager) {

        return MAIN_MENU;
    }
}
