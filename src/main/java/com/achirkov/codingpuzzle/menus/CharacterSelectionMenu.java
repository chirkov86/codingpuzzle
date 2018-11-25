package com.achirkov.codingpuzzle.menus;

import com.achirkov.codingpuzzle.menus.menuoptions.CharacterSelectionMenuOptions;

import java.util.Arrays;

public class CharacterSelectionMenu extends AbstractMenu implements Menu {

    public CharacterSelectionMenu(CharacterSelectionMenuOptions[] options) {
//        menuOptions = Arrays.asList(CharacterSelectionMenuOptions.values());
        menuOptions = Arrays.asList(options);
        menuText = new StringBuilder();
        menuText.append("Pick up your character:\n");
        appendMenuItems(menuText);
        menuText.append("Please enter your choice:..");
    }
}
