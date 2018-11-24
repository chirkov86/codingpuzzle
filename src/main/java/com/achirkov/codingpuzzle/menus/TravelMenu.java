package com.achirkov.codingpuzzle.menus;

import com.achirkov.codingpuzzle.game.GameContextManager;
import com.achirkov.codingpuzzle.menus.menuitems.TravelMenuOptions;

import java.util.Arrays;

public class TravelMenu extends AbstractMenu implements Menu {

    public TravelMenu() {
        menuOptions = Arrays.asList(TravelMenuOptions.values());
        sb = new StringBuilder();
        sb.append("You are on the map\n");
        sb.append("Use following options:\n");
        appendMenuItems(sb);
        sb.append("Please enter your choice:..");
    }

    @Override
    public void show(GameContextManager gameContextManager) {
        System.out.println(sb);
        System.out.println("Your current location is: " + gameContextManager.getGameMapManager().getPlayerPosition().toString() + "\n");
        gameContextManager.getGameMapManager().print();
    }


}
