package com.achirkov.codingpuzzle.game;

import com.achirkov.codingpuzzle.creatures.Player;
import com.achirkov.codingpuzzle.exceptions.SaveGameNotFoundException;
import com.achirkov.codingpuzzle.logger.Logger;
import com.achirkov.codingpuzzle.positioning.GameMapManager;
import com.achirkov.codingpuzzle.positioning.Position;
import com.achirkov.codingpuzzle.save.GameContextHolder;
import com.achirkov.codingpuzzle.save.GameContextSerializer;

/**
 * Main class responsible for holding and manipulating the game state.
 */
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
        gameContextSerializer = new GameContextSerializer();
        init();
    }

    /**
     * Method to save a game
     */
    public void save() {
        gameContextSerializer.serializeContext(new GameContextHolder(player, getGameMapManager().getGameMap()));
    }

    /**
     * Method to load game from a file
     */
    public void load() throws SaveGameNotFoundException {
        GameContextHolder contextHolder = null;
        try {
            contextHolder = gameContextSerializer.deserializeContext();
        } catch (SaveGameNotFoundException e) {
            LOGGER.debug(e.getMessage());
            throw e;
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

    public GameState getGameState() {
        return gameState;
    }

    void showDialog() {
        gameState.prepare(this);
    }

    void processInput(String command) {
        LOGGER.debug("Current state: " + gameState.toString());
        LOGGER.debug("Processing command: " + command);
        prevGameState = gameState;
        this.gameState = gameState.processInput(command, this);
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
