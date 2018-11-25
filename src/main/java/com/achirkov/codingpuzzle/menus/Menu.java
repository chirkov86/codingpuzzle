package com.achirkov.codingpuzzle.menus;

import com.achirkov.codingpuzzle.game.GameContextManager;
import com.achirkov.codingpuzzle.menus.menuoptions.MenuOption;

import java.util.List;

public interface Menu {

    void show(GameContextManager gameContextManager);

    List<String> getPossibleOptionInputs();

    MenuOption getOptionFromInput(String input);
}
