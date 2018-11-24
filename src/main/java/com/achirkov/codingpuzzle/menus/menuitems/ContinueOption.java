package com.achirkov.codingpuzzle.menus.menuitems;

public enum ContinueOption implements MenuOption {
    CONTINUE("1. Continue", 1),
    ;

    String stringValue;
    int intValue;

    ContinueOption(String stringValue, int intValue) {
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
