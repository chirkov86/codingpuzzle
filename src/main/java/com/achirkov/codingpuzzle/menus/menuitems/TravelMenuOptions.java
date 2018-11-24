package com.achirkov.codingpuzzle.menus.menuitems;

public enum TravelMenuOptions implements MenuOption {
    MOVE_NORTH("1 Move North", 1),
    MOVE_WEST("2 Move West", 2),
    MOVE_SOUTH("3 Move South", 3),
    MOVE_EAST("4 Move East", 4),
    BACK_TO_MAIN_MENU("5 Back to main menu", 5),
    ;

    String itemText;
    int intValue;

    TravelMenuOptions(String itemText, int intValue) {
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
