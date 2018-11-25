package com.achirkov.codingpuzzle.controllers;

import com.achirkov.codingpuzzle.game.GameContextManager;
import com.achirkov.codingpuzzle.game.GameState;
import com.achirkov.codingpuzzle.menus.Menu;

public interface StateController {

    void showMenu(GameContextManager gameContextManager);
    void showReport(GameContextManager gameContextManager);
    GameState processInput(String command, GameContextManager gameContextManager);
    Menu getMenu();

}
