package com.achirkov.codingpuzzle.controllers;

import com.achirkov.codingpuzzle.game.GameContextManager;
import com.achirkov.codingpuzzle.game.GameState;
import com.achirkov.codingpuzzle.menus.NameSelectionMenu;

public class NameSelectionMenuController extends AbstractController implements StateController {

    public NameSelectionMenuController() {
        this.menu = new NameSelectionMenu();
    }

    @Override
    public GameState processFreeFormInput(String input, GameContextManager gameContextManager) {
        gameContextManager.getPlayer().setName(input);
        return super.processFreeFormInput(input, gameContextManager);
    }
}
