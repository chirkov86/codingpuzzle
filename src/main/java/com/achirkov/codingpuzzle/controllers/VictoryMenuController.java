package com.achirkov.codingpuzzle.controllers;

import com.achirkov.codingpuzzle.creatures.Creature;
import com.achirkov.codingpuzzle.game.GameContextManager;
import com.achirkov.codingpuzzle.game.GameState;
import com.achirkov.codingpuzzle.menus.VictoryMenu;
import com.achirkov.codingpuzzle.menus.menuitems.MenuOption;

import static com.achirkov.codingpuzzle.game.GameState.TRAVEL;

public class VictoryMenuController extends AbstractController implements StateController {

    public VictoryMenuController() {
        menu = new VictoryMenu();
    }

    @Override
    public GameState processCommand(MenuOption command, GameContextManager gameContextManager) {
        return TRAVEL;
    }

    @Override
    public void showReport(GameContextManager gameContextManager) {

        Creature creature = gameContextManager.getGameMap().getEnemyAtCurrentPosition();

        System.out.println("Congratulations! You have killed a " + creature.getName());
        System.out.println("You have earned " + creature.getExpReward() + " exp points and " + creature.getMoneyReward() + " coins");
        gameContextManager.getPlayer().increaseExp(creature.getExpReward());
        gameContextManager.getPlayer().increaseMoney(creature.getMoneyReward());
    }
}
