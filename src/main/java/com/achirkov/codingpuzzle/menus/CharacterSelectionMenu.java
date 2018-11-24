package com.achirkov.codingpuzzle.menus;

import com.achirkov.codingpuzzle.menus.menuitems.CharacterSelectionMenuOptions;

import java.util.Arrays;

public class CharacterSelectionMenu extends AbstractMenu implements Menu {

    public CharacterSelectionMenu() {
        menuOptions = Arrays.asList(CharacterSelectionMenuOptions.values());
        sb = new StringBuilder();
        sb.append("Pick up your character:\n");
        appendMenuItems(sb);
        sb.append("Please enter your choice:..");
    }

}
