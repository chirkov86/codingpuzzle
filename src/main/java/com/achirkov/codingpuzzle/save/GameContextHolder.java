package com.achirkov.codingpuzzle.save;

import com.achirkov.codingpuzzle.creatures.Player;
import com.achirkov.codingpuzzle.positioning.GameMap;

import java.io.Serializable;

/**
 * Data class to enclose the game state to be serialized
 */
public class GameContextHolder implements Serializable {

    private Player player;
    private GameMap gameMap;

    public GameContextHolder(Player player, GameMap gameMap) {
        this.player = player;
        this.gameMap = gameMap;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public GameMap getGameMap() {
        return gameMap;
    }

    public void setGameMap(GameMap gameMap) {
        this.gameMap = gameMap;
    }
}