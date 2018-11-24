package com.achirkov.codingpuzzle.game;

import com.achirkov.codingpuzzle.creatures.Player;
import com.achirkov.codingpuzzle.logger.Logger;
import com.achirkov.codingpuzzle.menus.menuitems.MenuOption;
import com.achirkov.codingpuzzle.positioning.GameMapManager;
import com.achirkov.codingpuzzle.positioning.Position;

public class GameContextManager {

    private final static Logger LOGGER = Logger.getInstance();
    private GameState gameState;
    private GameState prevGameState;
    private Player player;
    private Position positionForAttack;
    private Position positionForFlee;
    private GameMapManager gameMapManager;
    private GameContextSerializer gameContextSerializer;

    GameContextManager() {
        init();
    }

    public void save() {
        gameContextSerializer.serializeContext(new GameContextHolder(player, getGameMapManager().getGameMap()));
    }

    public void load() {
        gameContextSerializer = new GameContextSerializer();
        GameContextHolder contextHolder = null;
        try {
            contextHolder = gameContextSerializer.deserializeContext();
        } catch (ClassNotFoundException e) {
            LOGGER.debug(e.getMessage());
        }
        if (contextHolder != null && contextHolder.getPlayer() != null && contextHolder.getGameMap() != null) {
            setPlayer(contextHolder.getPlayer());
            gameMapManager = new GameMapManager(contextHolder.getGameMap());
        }
    }

    /**
     * This method starts new game
     */
    public void init() {
        gameState = GameState.MAIN_MENU;
        gameMapManager = new GameMapManager(6);
    }

    public GameMapManager getGameMapManager() {
        return gameMapManager;
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
