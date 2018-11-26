package com.achirkov.codingpuzzle.save;

import com.achirkov.codingpuzzle.creatures.Player;
import com.achirkov.codingpuzzle.gamesetting.GameSetting;
import com.achirkov.codingpuzzle.positioning.GameMap;

import javax.annotation.Nonnull;
import java.io.Serializable;

/**
 * Data class to enclose the game state to be serialized
 */
public class GameContextHolder implements Serializable {
    public static final long serialVersionUID = 42L;
    private Player player;
    private GameMap gameMap;
    private GameSetting gameSetting;

    public GameContextHolder(@Nonnull Player player, @Nonnull GameMap gameMap, @Nonnull GameSetting gameSetting) {
        this.player = player;
        this.gameMap = gameMap;
        this.gameSetting = gameSetting;
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


    public GameSetting getGameSetting() {
        return gameSetting;
    }

    public void setGameSetting(GameSetting gameSetting) {
        this.gameSetting = gameSetting;
    }

}
