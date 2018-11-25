package com.achirkov.codingpuzzle.menus.menuoptions;

public enum TravelMenuOptions implements MenuOption {
    MOVE_NORTH("W Move North", 1, "W"),
    MOVE_WEST("A Move West", 2, "A"),
    MOVE_SOUTH("S Move South", 3, "S"),
    MOVE_EAST("D Move East", 4, "D"),
    BACK_TO_MAIN_MENU("5 Back to main menu", 5, "5"),
    ;

    String itemText;
    int intValue;
    String input;

    TravelMenuOptions(String itemText, int intValue, String input) {
        this.itemText = itemText;
        this.intValue = intValue;
        this.input = input;
    }

    @Override
    public String getMenuItemText() {
        return itemText;
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
