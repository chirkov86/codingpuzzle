package com.achirkov.codingpuzzle.menus;

import com.achirkov.codingpuzzle.game.GameContextManager;
import com.achirkov.codingpuzzle.menus.menuitems.MenuOption;

import java.util.List;

public interface Menu {

    void show(GameContextManager gameContextManager);

    List<String> getPossibleOptions();

    List<Integer> getPossibleOptionCodes();

    MenuOption getOptionFromCode(int code);
}
