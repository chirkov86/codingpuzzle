package com.achirkov.codingpuzzle.game;

import com.achirkov.codingpuzzle.creatures.Player;
import com.achirkov.codingpuzzle.positioning.GameMap;

class GameContextHolder {

    private Player player;
    private GameMap gameMap;

    GameContextHolder(Player player, GameMap gameMap) {
//        this.player = player;
        this.gameMap = gameMap;
    }

    static GameContextHolder from(Player player, GameMap gameMap) {
        return new GameContextHolder(player, gameMap);
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
