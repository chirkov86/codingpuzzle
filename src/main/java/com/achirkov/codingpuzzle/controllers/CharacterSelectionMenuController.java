package com.achirkov.codingpuzzle.controllers;

import com.achirkov.codingpuzzle.creatures.Knight;
import com.achirkov.codingpuzzle.creatures.Wizard;
import com.achirkov.codingpuzzle.game.GameContextManager;
import com.achirkov.codingpuzzle.game.GameState;
import com.achirkov.codingpuzzle.menus.CharacterSelectionMenu;
import com.achirkov.codingpuzzle.menus.menuoptions.CharacterSelectionMenuOptions;
import com.achirkov.codingpuzzle.menus.menuoptions.MenuOption;
import com.achirkov.codingpuzzle.positioning.Position;

import static com.achirkov.codingpuzzle.game.GameState.*;

public class CharacterSelectionMenuController extends AbstractController implements StateController {

    public CharacterSelectionMenuController() {
        menu = new CharacterSelectionMenu();
    }

    @Override
    public GameState processCommand(MenuOption command, GameContextManager gameContextManager) {
        switch ((CharacterSelectionMenuOptions) command) {
            case KNIGHT:
                System.out.println("You have chosen a knight!");
                gameContextManager.setPlayer(new Knight("Player1", Position.initial()));
                return NAME_SELECTION;
            case WIZARD:
                System.out.println("You have chosen a wizard!");
                gameContextManager.setPlayer(new Wizard("Player1", Position.initial()));
                return NAME_SELECTION;
            default:
                return MAIN_MENU;
        }
    }

    @Override
    public void showMenu(GameContextManager gameContextManager) {

        super.showMenu(gameContextManager);
    }
}
