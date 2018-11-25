package com.achirkov.codingpuzzle.menus;

import com.achirkov.codingpuzzle.game.GameContextManager;
import com.achirkov.codingpuzzle.menus.menuoptions.ContinueOption;

import java.util.Arrays;

public class VictoryMenu extends AbstractMenu implements Menu  {

    public VictoryMenu() {
        menuOptions = Arrays.asList(ContinueOption.values());
        menuText = new StringBuilder();
        menuText.append("What will you do?\n");
        appendMenuItems(menuText);
        menuText.append("Please enter your choice:..");
    }

    @Override
    public void show(GameContextManager gameContextManager) {
        super.show(gameContextManager);
    }
}
