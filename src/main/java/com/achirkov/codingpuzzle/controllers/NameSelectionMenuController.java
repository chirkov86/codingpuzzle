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
        System.out.println("user set name " + input);
        gameContextManager.getPlayer().setName(input);
        return super.processFreeFormInput(input, gameContextManager);
    }

    @Override
    public void showMenu(GameContextManager gameContextManager) {
        super.showMenu(gameContextManager);
    }

    @Override
    public void showReport(GameContextManager gameContextManager) {
        super.showReport(gameContextManager);
    }
}
