package com.achirkov.codingpuzzle.menus.menuoptions;

public enum CharacterSelectionMenuOptions implements MenuOption {

    // Characters for GameSetting.DUNGEON
    KNIGHT("1. Knight", 1),
    WIZARD("2. Wizard", 2),

    // Characters for GameSetting.LOTR
    ELF("1. Elf", 1),
    HOBBIT("2. Hobbit", 2),
    ;

    String stringValue;
    int intValue;
    String input;

    CharacterSelectionMenuOptions(String stringValue, int intValue) {
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
