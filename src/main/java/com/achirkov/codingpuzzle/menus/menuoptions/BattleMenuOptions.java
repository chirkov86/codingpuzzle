package com.achirkov.codingpuzzle.menus.menuoptions;

public enum BattleMenuOptions implements MenuOption {
    ATTACK("1. Attack", 1),
    FLEE("2. Flee", 2),
    ;

    String stringValue;
    int intValue;
    String input;

    BattleMenuOptions(String stringValue, int intValue) {
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
