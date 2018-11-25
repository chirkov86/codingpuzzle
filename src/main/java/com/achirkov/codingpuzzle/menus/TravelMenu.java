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
    }

    @Override
    public void show(GameContextManager gameContextManager) {
        System.out.println(menuText);
        String position = gameContextManager.getGameMapManager().getPlayerPosition().toString();
        System.out.println("Your current location is: " + position);
        gameContextManager.getGameMapManager().print();
        System.out.println("Please enter your choice:..");
    }
}
