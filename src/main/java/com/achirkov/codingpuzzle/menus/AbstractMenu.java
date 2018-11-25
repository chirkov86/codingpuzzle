package com.achirkov.codingpuzzle.menus;

import com.achirkov.codingpuzzle.exceptions.InvalidInputException;
import com.achirkov.codingpuzzle.game.GameContextManager;
import com.achirkov.codingpuzzle.menus.menuoptions.MenuOption;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractMenu implements Menu {

    StringBuilder menuText;
    List<MenuOption> menuOptions;

    @Override
    public void show(GameContextManager gameContextManager) {
        if (menuText != null) {
            System.out.println(menuText);
        }
    }

    @Override
    public List<String> getPossibleOptionInputs() {
        return menuOptions != null
                ? menuOptions.stream().map(MenuOption::getInput).collect(Collectors.toList())
                : null;
    }

    @Override
    public MenuOption getOptionFromCode(String input) {
        return menuOptions.stream()
                .filter(menuOption -> menuOption.getInput().equalsIgnoreCase(input))
                .findFirst()
                .orElseThrow(InvalidInputException::new);
    }

    void appendMenuItems(StringBuilder input) {
        if (input != null) {
            menuOptions.stream()
                    .map(MenuOption::getMenuItemText)
                    .forEach(str -> input.append(str).append("\n"));
        }
    }

}
