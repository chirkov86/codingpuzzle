package com.achirkov.codingpuzzle.controllers;

import com.achirkov.codingpuzzle.game.GameContextManager;
import com.achirkov.codingpuzzle.game.GameState;
import com.achirkov.codingpuzzle.menus.TravelMenu;
import com.achirkov.codingpuzzle.menus.menuitems.MenuOption;
import com.achirkov.codingpuzzle.menus.menuitems.TravelMenuOptions;
import com.achirkov.codingpuzzle.positioning.Direction;
import com.achirkov.codingpuzzle.positioning.Position;

import static com.achirkov.codingpuzzle.game.GameState.*;
import static com.achirkov.codingpuzzle.io.ColorCodes.ANSI_RED;
import static com.achirkov.codingpuzzle.io.ColorCodes.ANSI_RESET;

public class TravelMapController extends AbstractController implements StateController {

    public TravelMapController() {
        menu = new TravelMenu();
    }

    @Override
    public GameState processCommand(MenuOption command, GameContextManager gameContextManager) {

        switch ((TravelMenuOptions) command) {
            case MOVE_NORTH:
                return tryMove(gameContextManager, Direction.NORTH);
            case MOVE_WEST:
                return tryMove(gameContextManager, Direction.WEST);
            case MOVE_SOUTH:
                return tryMove(gameContextManager, Direction.SOUTH);
            case MOVE_EAST:
                return tryMove(gameContextManager, Direction.EAST);
            case BACK_TO_MAIN_MENU:
                return MAIN_MENU;
            default:
                return MAIN_MENU;
        }
    }

    private GameState tryMove(GameContextManager gameContextManager, Direction direction) {
        Position newPosition = gameContextManager.getGameMapManager().getPlayerPosition().getNewPositionToThe(direction);

        if (!gameContextManager.getGameMapManager().assertPositionIsValid(newPosition)) {
            System.out.println(ANSI_RED + "\n This move is not available!\n" + ANSI_RESET);
            return TRAVEL;
        }
        if (!gameContextManager.getGameMapManager().assertPositionIsFree(newPosition)) {
            System.out.println(ANSI_RED + "\n There is an enemy!\n" + ANSI_RESET);
            gameContextManager.setPositionForAttack(newPosition);
            gameContextManager.setPositionForFlee(gameContextManager.getGameMapManager().getPlayerPosition());
            return BATTLE_CONFIRMATION;
        }
        gameContextManager.getGameMapManager().setPlayerPosition(newPosition);
        return TRAVEL;
    }
}
