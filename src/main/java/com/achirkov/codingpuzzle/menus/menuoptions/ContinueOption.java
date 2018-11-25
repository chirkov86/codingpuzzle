package com.achirkov.codingpuzzle.menus.menuoptions;

public enum ContinueOption implements MenuOption {
    CONTINUE("1. Continue", 1),
    ;

    String stringValue;
    int intValue;
    String input;

    ContinueOption(String stringValue, int intValue) {
        this.stringValue = stringValue;
        this.intValue = intValue;
        this.input = String.valueOf(intValue);
    }

    @Override
    public String getMenuItemText() {
        return stringValue;
    }

    @Override
    public int getIntValue() {
        return intValue;
    }

    @Override
    public String getInput() {
        return input;
    }
}
