package com.achirkov.codingpuzzle.controllers;

import com.achirkov.codingpuzzle.game.GameContextManager;
import com.achirkov.codingpuzzle.game.GameState;
import com.achirkov.codingpuzzle.menus.Menu;
import com.achirkov.codingpuzzle.menus.menuitems.MenuOption;

public interface StateController {

    void showMenu(GameContextManager gameContextManager);
    void showReport(GameContextManager gameContextManager);
    GameState processCommand(MenuOption command, GameContextManager gameContextManager);
    Menu getMenu();

}
