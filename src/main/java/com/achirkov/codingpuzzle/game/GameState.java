package com.achirkov.codingpuzzle.game;

import com.achirkov.codingpuzzle.controllers.*;
import com.achirkov.codingpuzzle.menus.Menu;
import com.achirkov.codingpuzzle.menus.menuitems.MenuOption;
import com.achirkov.codingpuzzle.controllers.BattleConfirmationController;

/**
 * Game Finite State Machine representing all possible states and transitions between them.
 * Each state is processed by the corresponding {@code StateController}.
 * Processing is divided ito two stages:
 * <li> {@code prepare()} - shows initial game state dialog </li>
 * <li> {@code processCommand()} - processes input command and makes transition to a new state </li>
 *
 * Current state is the property of the {@code GameContextManager}.
 */
public enum GameState {
    MAIN_MENU(new MainStateController("")) {
        @Override
        public void prepare(GameContextManager gameContextManager) {
            stateStateController.showMenu(gameContextManager);
        }

        @Override
        public GameState processCommand(MenuOption command, GameContextManager gameContextManager) {
            return stateStateController.processCommand(command, gameContextManager);
        }
    },
    EXIT(new ExitStateController()) {
        public void prepare(GameContextManager gameContextManager) {
        }

        @Override
        public GameState processCommand(MenuOption command, GameContextManager gameContextManager) {
            return null;
        }
    },
    CHARACTER_SELECTION(new CharacterSelectionStateController()) {
        @Override
        public void prepare(GameContextManager gameContextManager) {
            stateStateController.showMenu(gameContextManager);
        }

        @Override
        public GameState processCommand(MenuOption command, GameContextManager gameContextManager) {
            return stateStateController.processCommand(command, gameContextManager);
        }
    },
    SAVE_GAME(null) {
        @Override
        public void prepare(GameContextManager gameContextManager) {
        }

        @Override
        public GameState processCommand(MenuOption command, GameContextManager gameContextManager) {
            return null;
        }
    },
    LOAD_GAME(null) {
        @Override
        public void prepare(GameContextManager gameContextManager) {
        }

        @Override
        public GameState processCommand(MenuOption command, GameContextManager gameContextManager) {
            return null;
        }
    },
    TRAVEL(new TravelMapController()) {
        @Override
        public void prepare(GameContextManager gameContextManager) {
            stateStateController.showMenu(gameContextManager);
        }

        @Override
        public GameState processCommand(MenuOption command, GameContextManager gameContextManager) {
            return stateStateController.processCommand(command, gameContextManager);
        }
    },
    BATTLE_CONFIRMATION(new BattleConfirmationController()) {
        @Override
        public void prepare(GameContextManager gameContextManager) {
            stateStateController.showMenu(gameContextManager);
        }

        @Override
        public GameState processCommand(MenuOption command, GameContextManager gameContextManager) {
            return stateStateController.processCommand(command, gameContextManager);
        }
    },
    BATTLE(new BattleController()) {
        @Override
        public void prepare(GameContextManager gameContextManager) {
            stateStateController.showMenu(gameContextManager);
        }

        @Override
        public GameState processCommand(MenuOption command, GameContextManager gameContextManager) {
            return stateStateController.processCommand(command, gameContextManager);
        }
    },
    VICTORY(new VictoryStateController()) {
        @Override
        public void prepare(GameContextManager gameContextManager) {
            stateStateController.showReport(gameContextManager);
            stateStateController.showMenu(gameContextManager);
        }

        @Override
        public GameState processCommand(MenuOption command, GameContextManager gameContextManager) {
            return stateStateController.processCommand(command, gameContextManager);
        }
    },
    DEATH(new DeathStateController()) {
        @Override
        public void prepare(GameContextManager gameContextManager) {
            stateStateController.showMenu(gameContextManager);
        }

        @Override
        public GameState processCommand(MenuOption command, GameContextManager gameContextManager) {
            return stateStateController.processCommand(command, gameContextManager);
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

    public abstract GameState processCommand(MenuOption command, GameContextManager gameContextManager);

    public abstract void prepare(GameContextManager gameContextManager);

}
