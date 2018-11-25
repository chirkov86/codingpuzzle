package com.achirkov.codingpuzzle.controllers;

import com.achirkov.codingpuzzle.game.GameContextManager;
import com.achirkov.codingpuzzle.game.GameState;
import com.achirkov.codingpuzzle.menus.menuoptions.MenuOption;

public class ResumeGameController extends AbstractController implements StateController {

    public ResumeGameController() {
    }

    @Override
    public GameState processCommand(MenuOption command, GameContextManager gameContextManager) {
        return super.processCommand(command, gameContextManager);
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
