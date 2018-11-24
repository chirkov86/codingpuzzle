package com.achirkov.codingpuzzle.controllers;

import com.achirkov.codingpuzzle.game.GameContextManager;
import com.achirkov.codingpuzzle.game.GameState;
import com.achirkov.codingpuzzle.menus.Menu;
import com.achirkov.codingpuzzle.menus.menuitems.MenuOption;

public abstract class AbstractController implements StateController {

    Menu menu;

    @Override
    public GameState processCommand(MenuOption command, GameContextManager gameContextManager) {
        System.out.println("Not implemented feature");
        return GameState.MAIN_MENU;
    }

    @Override
    public Menu getMenu() {
        return menu;
    }

    @Override
    public void showMenu(GameContextManager gameContextManager) {
        menu.show(gameContextManager);
    }

    @Override
    public void showReport(GameContextManager gameContextManager) {
        System.out.println("Not implemented feature");
    }
}
