package com.achirkov.codingpuzzle.menus.menuitems;

public enum CharacterSelectionMenuOptions implements MenuOption {
    KNIGHT("1. Knight", 1),
    WIZARD("2. Wizard", 2),
    ;

    String stringValue;
    int intValue;

    CharacterSelectionMenuOptions(String stringValue, int intValue) {
        this.stringValue = stringValue;
        this.intValue = intValue;
    }

    @Override
    public String getMenuItemText() {
        return stringValue;
    }

    @Override
    public int getIntValue() {
        return intValue;
    }
}
