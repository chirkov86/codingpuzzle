package com.achirkov.codingpuzzle.menus;

import com.achirkov.codingpuzzle.game.GameContextManager;
import com.achirkov.codingpuzzle.menus.menuitems.ContinueOption;

import java.util.Arrays;

public class VictoryMenu extends AbstractMenu implements Menu  {

    public VictoryMenu() {
        menuOptions = Arrays.asList(ContinueOption.values());
        sb = new StringBuilder();
        sb.append("What will you do?\n");
        appendMenuItems(sb);
        sb.append("Please enter your choice:..");
    }

    @Override
    public void show(GameContextManager gameContextManager) {
        super.show(gameContextManager);
    }
}
