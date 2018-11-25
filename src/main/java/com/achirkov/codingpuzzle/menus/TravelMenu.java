package com.achirkov.codingpuzzle.menus;

import com.achirkov.codingpuzzle.game.GameContextManager;
import com.achirkov.codingpuzzle.menus.menuoptions.TravelMenuOptions;

import java.util.Arrays;

public class TravelMenu extends AbstractMenu implements Menu {

    public TravelMenu() {
        menuOptions = Arrays.asList(TravelMenuOptions.values());
        menuText = new StringBuilder();
        menuText.append("You are on the map\n");
        menuText.append("Use following options:\n");
        appendMenuItems(menuText);
//        menuText.append("Please enter your choice:..");
    }

    @Override
    public void show(GameContextManager gameContextManager) {
        System.out.println(menuText);
        System.out.println("Your current location is: " + gameContextManager.getGameMapManager().getPlayerPosition().toString());
        gameContextManager.getGameMapManager().print();
        System.out.println("Please enter your choice:..");
    }
}
