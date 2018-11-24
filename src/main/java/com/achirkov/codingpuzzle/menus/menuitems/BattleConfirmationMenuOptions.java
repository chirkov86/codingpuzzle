package com.achirkov.codingpuzzle.menus.menuitems;

public enum BattleConfirmationMenuOptions implements MenuOption {
    ENGAGE("1. Engage the battle", 1),
    DO_NOT_ENGAGE("2. Do not engage the battle", 2),
    ;

    String stringValue;
    int intValue;

    BattleConfirmationMenuOptions(String stringValue, int intValue) {
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
