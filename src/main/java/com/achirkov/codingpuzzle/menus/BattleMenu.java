package com.achirkov.codingpuzzle.menus;

import com.achirkov.codingpuzzle.creatures.Creature;
import com.achirkov.codingpuzzle.creatures.Player;
import com.achirkov.codingpuzzle.game.GameContextManager;
import com.achirkov.codingpuzzle.io.IOUtils;
import com.achirkov.codingpuzzle.menus.menuitems.BattleMenuOptions;

import java.util.Arrays;

public class BattleMenu extends AbstractMenu implements Menu {

    public BattleMenu() {
        menuOptions = Arrays.asList(BattleMenuOptions.values());
        sb = new StringBuilder();
        sb.append("What will you do?\n");
        appendMenuItems(sb);
        sb.append("Please enter your choice:..");
    }

    @Override
    public void show(GameContextManager gameContextManager) {
        System.out.println("You are in the battle mode");
        printBattleModeInfo(gameContextManager);
        super.show(gameContextManager);
    }

    private void printBattleModeInfo(GameContextManager gameContextManager) {

        //TODO implement as a separate Presenter class
        //TODO do not create a new string each time, need to use pre-constructed one
        Player player = gameContextManager.getPlayer();
        Creature monster = gameContextManager.getGameMap().getEnemyAtCurrentPosition();
        StringBuilder sb = new StringBuilder();
        sb.append("______|").append(IOUtils.padLeft("Player|", 16)).append(IOUtils.padLeft("Monster", 16)).append("\n");
        sb.append(" Class|").append(IOUtils.padLeft(player.getName(), 15)).append("|").append(IOUtils.padLeft(monster.getName(), 16)).append("\n");
        sb.append("    HP|").append(IOUtils.padLeft(String.valueOf(player.getCurrentHitPoints()), 15)).append("|").append(IOUtils.padLeft(String.valueOf(monster.getCurrentHitPoints()), 16)).append("\n");
        sb.append("Damage|").append(IOUtils.padLeft(player.getDamageInfo(), 15)).append("|").append(IOUtils.padLeft(monster.getDamageInfo(), 16)).append("\n");
        System.out.println(sb);
    }
}
