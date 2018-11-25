package com.achirkov.codingpuzzle.menus;

import com.achirkov.codingpuzzle.game.GameContextManager;
import com.achirkov.codingpuzzle.menus.menuoptions.BattleConfirmationMenuOptions;

import java.util.Arrays;

public class BattleConfirmationMenu extends AbstractMenu implements Menu {

    public BattleConfirmationMenu() {
        menuOptions = Arrays.asList(BattleConfirmationMenuOptions.values());
        menuText = new StringBuilder();
        menuText.append("What will you do?\n");
        appendMenuItems(menuText);
        menuText.append("Please enter your choice:..");
    }

    @Override
    public void show(GameContextManager gameContextManager) {
        System.out.println("You spotted an enemy in this direction");
        super.show(gameContextManager);
    }
}
