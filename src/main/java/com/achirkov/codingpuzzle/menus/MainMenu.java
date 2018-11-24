package com.achirkov.codingpuzzle.menus;

import com.achirkov.codingpuzzle.menus.menuitems.MainMenuOptions;

import java.util.Arrays;

public class MainMenu extends AbstractMenu implements Menu {

    public MainMenu(final String gameName) {
        menuOptions = Arrays.asList(MainMenuOptions.values());
        sb = new StringBuilder();
        sb.append("Welcome to ");
        sb.append(gameName);
        sb.append("!\n");
        sb.append("Main Menu:\n");
        appendMenuItems(sb);
        sb.append("Please enter your choice:..");
    }

}
