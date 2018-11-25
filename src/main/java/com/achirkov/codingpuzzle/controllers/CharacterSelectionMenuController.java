package com.achirkov.codingpuzzle.controllers;

import com.achirkov.codingpuzzle.creatures.Elf;
import com.achirkov.codingpuzzle.creatures.Hobbit;
import com.achirkov.codingpuzzle.creatures.Knight;
import com.achirkov.codingpuzzle.creatures.Wizard;
import com.achirkov.codingpuzzle.game.GameContextManager;
import com.achirkov.codingpuzzle.game.GameState;
import com.achirkov.codingpuzzle.gamesetting.GameSetting;
import com.achirkov.codingpuzzle.menus.CharacterSelectionMenu;
import com.achirkov.codingpuzzle.menus.menuoptions.CharacterSelectionMenuOptions;
import com.achirkov.codingpuzzle.menus.menuoptions.MenuOption;
import com.achirkov.codingpuzzle.positioning.Position;

import static com.achirkov.codingpuzzle.game.GameState.MAIN_MENU;
import static com.achirkov.codingpuzzle.game.GameState.NAME_SELECTION;

public class CharacterSelectionMenuController extends AbstractController {

    @Override
    public GameState processCommand(MenuOption command, GameContextManager gameContextManager) {
        switch ((CharacterSelectionMenuOptions) command) {

            // Characters for GameSetting.DUNGEON
            case KNIGHT:
                System.out.println("You have chosen a knight!");
                gameContextManager.setPlayer(new Knight("Player1", Position.initial()));
                return NAME_SELECTION;
            case WIZARD:
                System.out.println("You have chosen a wizard!");
                gameContextManager.setPlayer(new Wizard("Player1", Position.initial()));
                return NAME_SELECTION;

            // Characters for GameSetting.LOTR
            case ELF:
                System.out.println("You have chosen an elf!");
                gameContextManager.setPlayer(new Elf("Player1", Position.initial()));
                return NAME_SELECTION;
            case HOBBIT:
                System.out.println("You have chosen a hobbit!");
                gameContextManager.setPlayer(new Hobbit("Player1", Position.initial()));
                return NAME_SELECTION;

            default:
                return MAIN_MENU;
        }
    }

    /**
     * Extension point to introduce new characters
     */
    @Override
    public void showMenu(GameContextManager gameContextManager) {
        GameSetting gameSetting = gameContextManager.getGameSetting();

        CharacterSelectionMenuOptions[] characterSelectionMenuOptions;
        if (gameSetting.equals(GameSetting.DUNGEON)) {
            characterSelectionMenuOptions = new CharacterSelectionMenuOptions[]{CharacterSelectionMenuOptions.KNIGHT,
                    CharacterSelectionMenuOptions.WIZARD};
        } else {
            characterSelectionMenuOptions = new CharacterSelectionMenuOptions[]{CharacterSelectionMenuOptions.ELF,
                    CharacterSelectionMenuOptions.HOBBIT};
        }

        setMenu(new CharacterSelectionMenu(characterSelectionMenuOptions));
        super.showMenu(gameContextManager);
    }

}
