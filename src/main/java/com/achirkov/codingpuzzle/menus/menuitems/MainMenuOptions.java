package com.achirkov.codingpuzzle.menus.menuitems;

public enum MainMenuOptions implements MenuOption {
    START_NEW_GAME("1. Start a new game", 1),
    SAVE_GAME("2. Save game", 2),
    RESUME_GAME("3. Resume game", 3),
    EXIT("4. Exit", 4),
    ;

    String itemText;
    int intValue;

    MainMenuOptions(String itemText, int intValue) {
        this.itemText = itemText;
        this.intValue = intValue;
    }

    @Override
    public String getMenuItemText() {
        return itemText;
    }

    @Override
    public int getIntValue() {
        return intValue;
    }
}
