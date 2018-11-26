package com.achirkov.codingpuzzle.game;

import com.achirkov.codingpuzzle.creatures.Player;
import com.achirkov.codingpuzzle.exceptions.SaveGameNotFoundException;
import com.achirkov.codingpuzzle.gamesetting.GameSetting;
import com.achirkov.codingpuzzle.logger.Logger;
import com.achirkov.codingpuzzle.positioning.GameMapManager;
import com.achirkov.codingpuzzle.positioning.Position;
import com.achirkov.codingpuzzle.save.GameContextHolder;
import com.achirkov.codingpuzzle.save.GameContextSerializer;

import javax.annotation.Nonnull;

/**
 * Main class responsible for holding and manipulating the game state.
 */
public class GameContextManager {

    private final static Logger LOGGER = Logger.getInstance();
    private GameState gameState;
    private Player player;
    private Position positionForAttack;
    private Position positionForFlee;
    private GameMapManager gameMapManager;
    private final GameContextSerializer gameContextSerializer;
    private final GameSetting gameSetting;

    public GameContextManager(GameSetting gameSetting) {
        this.gameSetting = gameSetting;
        gameContextSerializer = new GameContextSerializer();
        init();
    }

    /**
     * This method starts new game
     */
    public final void init() {
        gameState = GameState.MAIN_MENU;
        gameMapManager = new GameMapManager(6, gameSetting);
    }

    /**
     * Method to save a game
     */
    public void save() {
        gameContextSerializer.serializeContext(new GameContextHolder(player, getGameMapManager().getGameMap(), gameSetting));
    }

    /**
     * Method to load game from a file
     */
    public void load() throws SaveGameNotFoundException {
        GameContextHolder contextHolder;
        try {
            contextHolder = gameContextSerializer.deserializeContext();
        } catch (SaveGameNotFoundException e) {
            LOGGER.debug(e.getMessage());
            throw e;
        }
        if (contextHolder != null
                && contextHolder.getPlayer() != null
                && contextHolder.getGameMap() != null
                && contextHolder.getGameSetting() != null) {
            setPlayer(contextHolder.getPlayer());
            gameMapManager = new GameMapManager(contextHolder.getGameMap(), contextHolder.getGameSetting());
        }
    }

    void processInput(@Nonnull String command) {
        LOGGER.debug("Current state: " + gameState.toString());
        LOGGER.debug("Processing command: " + command);
        this.gameState = gameState.processInput(command, this);
        LOGGER.debug("New state: " + gameState.toString());
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

    public GameSetting getGameSetting() {
        return gameSetting;
    }
}
