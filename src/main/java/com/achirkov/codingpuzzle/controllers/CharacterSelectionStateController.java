package com.achirkov.codingpuzzle.controllers;

import com.achirkov.codingpuzzle.creatures.Knight;
import com.achirkov.codingpuzzle.creatures.Wizard;
import com.achirkov.codingpuzzle.game.GameContextManager;
import com.achirkov.codingpuzzle.game.GameState;
import com.achirkov.codingpuzzle.menus.CharacterSelectionMenu;
import com.achirkov.codingpuzzle.menus.menuitems.CharacterSelectionMenuOptions;
import com.achirkov.codingpuzzle.menus.menuitems.MenuOption;
import com.achirkov.codingpuzzle.positioning.Position;

import static com.achirkov.codingpuzzle.game.GameState.MAIN_MENU;
import static com.achirkov.codingpuzzle.game.GameState.TRAVEL;

public class CharacterSelectionStateController extends AbstractStateController implements StateController {

    public CharacterSelectionStateController() {
        menu = new CharacterSelectionMenu();
    }

    @Override
    public GameState processCommand(MenuOption command, GameContextManager gameContextManager) {
        switch ((CharacterSelectionMenuOptions) command) {
            case KNIGHT:
                System.out.println("You have chosen a knight!");
                gameContextManager.setPlayer(new Knight("Hero Name", Position.initial()));
                return TRAVEL;
            case WIZARD:
                System.out.println("You have chosen a wizard!");
                gameContextManager.setPlayer(new Wizard("Hero Name", Position.initial()));
                return TRAVEL;
            default:
                return MAIN_MENU;
        }
    }
}
