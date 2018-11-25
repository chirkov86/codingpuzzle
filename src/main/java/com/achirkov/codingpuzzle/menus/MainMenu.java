package com.achirkov.codingpuzzle.menus;

import com.achirkov.codingpuzzle.menus.menuoptions.MainMenuOptions;

import java.util.Arrays;

public class MainMenu extends AbstractMenu implements Menu {

    public MainMenu(final String gameName) {
        menuOptions = Arrays.asList(MainMenuOptions.values());
        menuText = new StringBuilder();
        menuText.append("Welcome to ");
        menuText.append(gameName);
        menuText.append("!\n");
        menuText.append("Main Menu:\n");
        appendMenuItems(menuText);
        menuText.append("Please enter your choice:..");
    }

}
