package com.achirkov.codingpuzzle.positioning;

import com.achirkov.codingpuzzle.creatures.Creature;
import com.achirkov.codingpuzzle.items.Item;

import java.io.Serializable;
import java.util.Collection;

/**
 * Data object class.
 * Is used to save game.
 */
public class GameMap implements Serializable {
    private int dimension;
    private boolean fogOfWar[][];
    private Collection<Creature> enemies;
    private Collection<Item> treasures;
    private Position playerPosition;

    public GameMap(int dimension, Collection<Creature> enemies, Collection<Item> treasures, Position playerPosition) {
        this.dimension = dimension;
        this.fogOfWar = new boolean[dimension][dimension];
        this.enemies = enemies;
        this.treasures = treasures;
        this.playerPosition = playerPosition;
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public Collection<Creature> getEnemies() {
        return enemies;
    }

    public void setEnemies(Collection<Creature> enemies) {
        this.enemies = enemies;
    }

    public Position getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(Position playerPosition) {
        this.playerPosition = playerPosition;
    }

    public boolean[][] getFogOfWar() {
        return fogOfWar;
    }

    public void setFogOfWar(boolean[][] fogOfWar) {
        this.fogOfWar = fogOfWar;
    }

    public Collection<Item> getTreasures() {
        return treasures;
    }

    public void setTreasures(Collection<Item> treasures) {
        this.treasures = treasures;
    }
}
