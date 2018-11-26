package com.achirkov.codingpuzzle.controllers;

import com.achirkov.codingpuzzle.game.GameContextManager;
import com.achirkov.codingpuzzle.game.GameState;
import com.achirkov.codingpuzzle.menus.Menu;

import javax.annotation.Nonnull;

public interface StateController {

    void showMenu(GameContextManager gameContextManager);
    void showReport(GameContextManager gameContextManager);
    GameState processInput(@Nonnull String command, @Nonnull GameContextManager gameContextManager);
    Menu getMenu();

}
