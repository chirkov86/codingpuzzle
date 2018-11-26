package com.achirkov.codingpuzzle.controllers;

import com.achirkov.codingpuzzle.game.GameContextManager;
import com.achirkov.codingpuzzle.game.GameState;
import com.achirkov.codingpuzzle.items.Item;
import com.achirkov.codingpuzzle.menus.TravelMenu;
import com.achirkov.codingpuzzle.menus.menuoptions.MenuOption;
import com.achirkov.codingpuzzle.menus.menuoptions.TravelMenuOptions;
import com.achirkov.codingpuzzle.positioning.Direction;
import com.achirkov.codingpuzzle.positioning.Position;

import java.util.Optional;

import static com.achirkov.codingpuzzle.game.GameState.*;
import static com.achirkov.codingpuzzle.io.ColorCodes.*;

public class TravelMapController extends AbstractController {

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
        Position newPosition =
                gameContextManager.getGameMapManager().getPlayerPosition().getNewPositionToThe(direction);

        if (!gameContextManager.getPlayer().isAlive()) {
            System.out.println(ANSI_RED + "\n Hero is dead and can not move anymore!\n" + ANSI_RESET);
            return TRAVEL;
        }

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
        gameContextManager.getGameMapManager().takeTreasureAt(newPosition)
                .ifPresent(treasure -> {
                    gameContextManager.getPlayer().increaseMoney(treasure.getValue());
                    System.out.println(new StringBuilder().append(ANSI_YELLOW)
                            .append("\n Congratulations! You have found a treasure worth of ")
                            .append(treasure.getValue())
                            .append(" gold coins!\n")
                            .append(ANSI_RESET));
                });
        return TRAVEL;
    }
}
