package com.achirkov.codingpuzzle.menus;

import com.achirkov.codingpuzzle.menus.menuoptions.ContinueOption;

import java.util.Arrays;

public class DeathMenu extends AbstractMenu implements Menu {

    public DeathMenu() {
        menuOptions = Arrays.asList(ContinueOption.values());
        menuText = new StringBuilder();
        appendMenuItems(menuText);
        menuText.append("Please enter your choice:..");
    }
}
