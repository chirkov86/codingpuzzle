package com.achirkov.codingpuzzle.menus;

import com.achirkov.codingpuzzle.game.GameContextManager;
import com.achirkov.codingpuzzle.menus.menuitems.MenuOption;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractMenu implements Menu {

    StringBuilder sb;
    List<MenuOption> menuOptions;

    @Override
    public void show(GameContextManager gameContextManager) {
        if (sb != null) {
            System.out.println(sb);
        }
    }

    @Override
    public List<String> getPossibleOptions() {
        return menuOptions.stream().map(MenuOption::name).collect(Collectors.toList());
    }

    @Override
    public List<Integer> getPossibleOptionCodes() {
        return menuOptions.stream().map(MenuOption::getIntValue).collect(Collectors.toList());
    }

    @Override
    public MenuOption getOptionFromCode(int code) {
        //TODO assert before accessing
        return menuOptions.get(code - 1);
    }

    public StringBuilder appendMenuItems(final StringBuilder sb2) {
        if (sb2 != null) {
            menuOptions.stream()
                    .map(MenuOption::getMenuItemText)
                    .forEach(str -> sb2.append(str).append("\n"));
        }
        return sb2;
    }
}
