package com.achirkov.codingpuzzle.menus.menuoptions;

public enum BattleConfirmationMenuOptions implements MenuOption {
    ENGAGE("1. Engage the battle", 1),
    DO_NOT_ENGAGE("2. Do not engage", 2),
    ;

    String stringValue;
    int intValue;
    String input;

    BattleConfirmationMenuOptions(String stringValue, int intValue) {
        this.stringValue = stringValue;
        this.intValue = intValue;
        this.input = String.valueOf(intValue);
    }

    @Override
    public String getMenuItemText() {
        return stringValue;
    }

    @Override
    public String getInput() {
        return input;
    }
}
