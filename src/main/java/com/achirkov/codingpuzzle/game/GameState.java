package com.achirkov.codingpuzzle.game;

import com.achirkov.codingpuzzle.controllers.*;
import com.achirkov.codingpuzzle.menus.Menu;
import com.achirkov.codingpuzzle.controllers.BattleConfirmationController;

/**
 * Game Finite State Machine representing all possible states and transitions between them.
 * Each state is processed by the corresponding {@code StateController}.
 * Processing is divided into two stages:
 * <li> {@code prepare()} - shows initial game state dialog </li>
 * <li> {@code processInput()} - processes input command and makes transition to a new state </li>
 *
 * Current state is the property of the {@code GameContextManager}.
 */
public enum GameState {
    MAIN_MENU(new MainMenuController("")) {
        @Override
        public void prepare(GameContextManager gameContextManager) {
            stateStateController.showMenu(gameContextManager);
        }

        @Override
        public GameState processInput(String input, GameContextManager gameContextManager) {
            return stateStateController.processInput(input, gameContextManager);
        }
    },
    EXIT(new ExitMenuController()) {
        public void prepare(GameContextManager gameContextManager) {
        }

        @Override
        public GameState processInput(String input, GameContextManager gameContextManager) {
            return null;
        }
    },
    CHARACTER_SELECTION(new CharacterSelectionMenuController()) {
        @Override
        public void prepare(GameContextManager gameContextManager) {
            stateStateController.showMenu(gameContextManager);
        }

        @Override
        public GameState processInput(String input, GameContextManager gameContextManager) {
            return stateStateController.processInput(input, gameContextManager);
        }
    },
    NAME_SELECTION(new NameSelectionMenuController()){
        @Override
        public void prepare(GameContextManager gameContextManager) {
            stateStateController.showReport(gameContextManager);
            stateStateController.showMenu(gameContextManager);
        }

        @Override
        public GameState processInput(String input, GameContextManager gameContextManager) {
            return stateStateController.processInput(input, gameContextManager);
        }
    },
    TRAVEL(new TravelMapController()) {
        @Override
        public void prepare(GameContextManager gameContextManager) {
            stateStateController.showMenu(gameContextManager);
        }

        @Override
        public GameState processInput(String input, GameContextManager gameContextManager) {
            return stateStateController.processInput(input, gameContextManager);
        }
    },
    BATTLE_CONFIRMATION(new BattleConfirmationController()) {
        @Override
        public void prepare(GameContextManager gameContextManager) {
            stateStateController.showMenu(gameContextManager);
        }

        @Override
        public GameState processInput(String input, GameContextManager gameContextManager) {
            return stateStateController.processInput(input, gameContextManager);
        }
    },
    BATTLE(new BattleController()) {
        @Override
        public void prepare(GameContextManager gameContextManager) {
            stateStateController.showMenu(gameContextManager);
        }

        @Override
        public GameState processInput(String input, GameContextManager gameContextManager) {
            return stateStateController.processInput(input, gameContextManager);
        }
    },
    VICTORY(new VictoryMenuController()) {
        @Override
        public void prepare(GameContextManager gameContextManager) {
            stateStateController.showReport(gameContextManager);
            stateStateController.showMenu(gameContextManager);
        }

        @Override
        public GameState processInput(String input, GameContextManager gameContextManager) {
            return stateStateController.processInput(input, gameContextManager);
        }
    },
    DEATH(new DeathMenuController()) {
        @Override
        public void prepare(GameContextManager gameContextManager) {
            stateStateController.showMenu(gameContextManager);
        }

        @Override
        public GameState processInput(String input, GameContextManager gameContextManager) {
            return stateStateController.processInput(input, gameContextManager);
        }

    },
    ;

    StateController stateStateController;

    GameState(StateController stateStateController) {
        this.stateStateController = stateStateController;
    }

    public Menu getStateMenu() {
        return stateStateController.getMenu();
    }

    public abstract GameState processInput(String input, GameContextManager gameContextManager);

    public abstract void prepare(GameContextManager gameContextManager);

}
