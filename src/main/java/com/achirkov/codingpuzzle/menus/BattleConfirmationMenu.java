package com.achirkov.codingpuzzle.menus;

import com.achirkov.codingpuzzle.menus.menuoptions.BattleConfirmationMenuOptions;

import java.util.Arrays;

public class BattleConfirmationMenu extends AbstractMenu implements Menu {

    public BattleConfirmationMenu() {
        menuOptions = Arrays.asList(BattleConfirmationMenuOptions.values());
        menuText = new StringBuilder();
        menuText.append("You spotted an enemy in this direction. ");
        menuText.append("What will you do?\n");
        appendMenuItems(menuText);
        menuText.append("Please enter your choice:..");
    }
}
