package com.achirkov.codingpuzzle.menus;

import com.achirkov.codingpuzzle.menus.menuitems.ContinueOption;

import java.util.Arrays;

public class DeathMenu extends AbstractMenu implements Menu {

    public DeathMenu() {
        menuOptions = Arrays.asList(ContinueOption.values());
        sb = new StringBuilder();
        appendMenuItems(sb);
        sb.append("Please enter your choice:..");
    }
}
