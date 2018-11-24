package com.achirkov.codingpuzzle.menus.menuitems;

public enum BattleMenuOptions implements MenuOption {
    ATTACK("1. Attack", 1),
    FLEE("2. Flee", 2),
    ;

    String stringValue;
    int intValue;

    BattleMenuOptions(String stringValue, int intValue) {
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
