package com.achirkov.codingpuzzle.controllers;

import com.achirkov.codingpuzzle.creatures.Creature;
import com.achirkov.codingpuzzle.game.GameContextManager;
import com.achirkov.codingpuzzle.game.GameState;
import com.achirkov.codingpuzzle.menus.VictoryMenu;
import com.achirkov.codingpuzzle.menus.menuoptions.MenuOption;

import static com.achirkov.codingpuzzle.game.GameState.TRAVEL;
import static com.achirkov.codingpuzzle.io.ColorCodes.ANSI_RESET;
import static com.achirkov.codingpuzzle.io.ColorCodes.ANSI_YELLOW;

public class VictoryMenuController extends AbstractController {

    public VictoryMenuController() {
        menu = new VictoryMenu();
    }

    @Override
    public GameState processCommand(MenuOption command, GameContextManager gameContextManager) {
        return TRAVEL;
    }

    @Override
    public void showReport(GameContextManager gameContextManager) {

        Creature creature = gameContextManager.getGameMapManager().getEnemyAtCurrentPosition();

        System.out.println(new StringBuilder().append(ANSI_YELLOW)
                .append("\n Congratulations! You have killed a ")
                .append(creature.getName())
                .append(".\n You have earned ")
                .append(creature.getExpReward())
                .append(" exp points and ")
                .append(creature.getMoneyReward())
                .append(" coins.\n")
                .append(ANSI_RESET));
        gameContextManager.getPlayer().increaseExp(creature.getExpReward());
        gameContextManager.getPlayer().increaseMoney(creature.getMoneyReward());
    }
}
