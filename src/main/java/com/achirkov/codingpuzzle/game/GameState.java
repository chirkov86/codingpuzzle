package com.achirkov.codingpuzzle.game;

import com.achirkov.codingpuzzle.controllers.*;
import com.achirkov.codingpuzzle.menus.Menu;

import javax.annotation.Nonnull;

/**
 * Game Finite State Machine representing all possible states and transitions between them.
 * Each state is processed by the corresponding {@code StateController}.
 * Processing is divided into two stages:
 * <li> {@code prepare()} - shows initial game state dialog </li>
 * <li> {@code processInput()} - processes input command and makes transition to a new state </li>
 * <p>
 * Current state is the property of the {@code GameContextManager}.
 */
public enum GameState {
    MAIN_MENU(new MainMenuController()),
    EXIT(new ExitMenuController()),
    CHARACTER_SELECTION(new CharacterSelectionMenuController()),
    NAME_SELECTION(new NameSelectionMenuController()),
    TRAVEL(new TravelMapController()),
    BATTLE_CONFIRMATION(new BattleConfirmationController()),
    BATTLE(new BattleController()),
    VICTORY(new VictoryMenuController()),
    DEATH(new DeathMenuController()),
    ;

    StateController stateStateController;

    GameState(@Nonnull StateController stateStateController) {
        this.stateStateController = stateStateController;
    }

    public Menu getStateMenu() {
        return stateStateController.getMenu();
    }

    public GameState processInput(@Nonnull String input, @Nonnull GameContextManager gameContextManager) {
        return stateStateController.processInput(input, gameContextManager);
    }

    public void prepare(@Nonnull GameContextManager gameContextManager) {
        stateStateController.showReport(gameContextManager);
        stateStateController.showMenu(gameContextManager);
    }
}
