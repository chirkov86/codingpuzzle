package com.achirkov.codingpuzzle.game;

import com.achirkov.codingpuzzle.creatures.Player;
import com.achirkov.codingpuzzle.logger.Logger;
import com.achirkov.codingpuzzle.menus.menuitems.MenuOption;
import com.achirkov.codingpuzzle.positioning.GameMap;
import com.achirkov.codingpuzzle.positioning.Position;

public class GameContextManager {

    private final static Logger LOGGER = Logger.getInstance();
    private GameState gameState;
    private GameState prevGameState;
    private Player player;
    private GameMap gameMap;
    private Position positionForAttack;
    private Position positionForFlee;

    GameContextManager() {
        init();
    }

    public void save(GameContextManager gameContextManager) {
        GameContextHolder.from(player, gameMap);
    }

    public void init() {
        gameState = GameState.MAIN_MENU;
        gameMap = new GameMap(4);
    }

    public GameMap getGameMap() {
        return gameMap;
    }

    GameState getGameState() {
        return gameState;
    }

    void showDialog() {
        gameState.prepare(this);
    }

    void processCommand(MenuOption command) {
        LOGGER.debug("Current state: " + gameState.toString());
        LOGGER.debug("Processing command: " + command);
        prevGameState = gameState;
        this.gameState = gameState.processCommand(command, this);
        LOGGER.debug("New state: " + gameState.toString());
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Position getPositionForAttack() {
        return positionForAttack;
    }

    public void setPositionForAttack(Position position) {
        this.positionForAttack = position;
    }

    public Position getPositionForFlee() {
        return positionForFlee;
    }

    public void setPositionForFlee(Position positionForFlee) {
        this.positionForFlee = positionForFlee;
    }

    public GameState getPrevGameState() {
        return prevGameState;
    }
}
