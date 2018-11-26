package com.achirkov.codingpuzzle.menus;

import com.achirkov.codingpuzzle.creatures.Creature;
import com.achirkov.codingpuzzle.creatures.Player;
import com.achirkov.codingpuzzle.game.GameContextManager;
import com.achirkov.codingpuzzle.io.IOUtils;
import com.achirkov.codingpuzzle.menus.menuoptions.BattleMenuOptions;

import java.util.Arrays;

import static com.achirkov.codingpuzzle.io.ColorCodes.*;

public class BattleMenu extends AbstractMenu implements Menu {

    public BattleMenu() {
        menuOptions = Arrays.asList(BattleMenuOptions.values());
        menuText = new StringBuilder();
        menuText.append("What will you do?\n");
        appendMenuItems(menuText);
        menuText.append("Please enter your choice:..");
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
        Creature monster = gameContextManager.getGameMapManager().getEnemyAtPlayerPosition();
        StringBuilder sb = new StringBuilder(200);

        sb.append("______|")
                .append(ANSI_BLUE)
                .append(IOUtils.padLeft(player.getName(), 15))
                .append(ANSI_RESET)
                .append("|")
                .append(ANSI_RED)
                .append(IOUtils.padLeft("Monster", 16))
                .append(ANSI_RESET)
                .append("\n");

        sb.append(" Class|")
                .append(ANSI_BLUE)
                .append(IOUtils.padLeft(player.getCharacterClass(), 15))
                .append(ANSI_RESET)
                .append("|")
                .append(ANSI_RED)
                .append(IOUtils.padLeft(monster.getName(), 16))
                .append(ANSI_RESET)
                .append("\n");

        sb.append("    HP|")
                .append(ANSI_BLUE)
                .append(IOUtils.padLeft(String.valueOf(player.getCurrentHitPoints()), 15))
                .append(ANSI_RESET)
                .append("|")
                .append(ANSI_RED)
                .append(IOUtils.padLeft(String.valueOf(monster.getCurrentHitPoints()), 16))
                .append(ANSI_RESET)
                .append("\n");

        sb.append("Damage|")
                .append(ANSI_BLUE)
                .append(IOUtils.padLeft(player.getDamageInfo(), 15))
                .append(ANSI_RESET)
                .append("|")
                .append(ANSI_RED)
                .append(IOUtils.padLeft(monster.getDamageInfo(), 16))
                .append(ANSI_RESET)
                .append("\n");

        System.out.println(sb);
    }
}
