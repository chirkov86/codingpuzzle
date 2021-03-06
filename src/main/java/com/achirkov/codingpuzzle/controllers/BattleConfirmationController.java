package com.achirkov.codingpuzzle.controllers;

import com.achirkov.codingpuzzle.game.GameContextManager;
import com.achirkov.codingpuzzle.game.GameState;
import com.achirkov.codingpuzzle.menus.BattleConfirmationMenu;
import com.achirkov.codingpuzzle.menus.menuoptions.BattleConfirmationMenuOptions;
import com.achirkov.codingpuzzle.menus.menuoptions.MenuOption;
import com.achirkov.codingpuzzle.positioning.Position;

import static com.achirkov.codingpuzzle.game.GameState.*;

public class BattleConfirmationController  extends AbstractController {

    public BattleConfirmationController() {
        menu = new BattleConfirmationMenu();
    }

    @Override
    public GameState processCommand(MenuOption command, GameContextManager gameContextManager) {
        switch ((BattleConfirmationMenuOptions) command) {
            case ENGAGE:
                Position positionForAttack = gameContextManager.getPositionForAttack();
                gameContextManager.getGameMapManager().setPlayerPosition(positionForAttack);
                gameContextManager.setPositionForAttack(null);
                System.out.println("You have engaged the battle!");
                return BATTLE;
            case DO_NOT_ENGAGE:
                gameContextManager.setPositionForAttack(null);
                gameContextManager.setPositionForFlee(null);
                return TRAVEL;
            default:
                return MAIN_MENU;
        }
    }
}
