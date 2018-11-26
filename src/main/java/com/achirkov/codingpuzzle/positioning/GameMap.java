package com.achirkov.codingpuzzle.positioning;

import com.achirkov.codingpuzzle.creatures.Creature;
import com.achirkov.codingpuzzle.items.Item;

import java.io.Serializable;
import java.util.Collection;

/**
 * Data object class.
 * Currently is only NxN supported.
 * TODO: re-work to NxM
 * This class is used to save game.
 */
public class GameMap implements Serializable {
    public static final long serialVersionUID = 42L;
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

    // required for serialization
    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public Collection<Creature> getEnemies() {
        return enemies;
    }

    // required for serialization
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

    // required for serialization
    public void setFogOfWar(boolean[][] fogOfWar) {
        this.fogOfWar = fogOfWar;
    }

    public Collection<Item> getTreasures() {
        return treasures;
    }

    // required for serialization
    public void setTreasures(Collection<Item> treasures) {
        this.treasures = treasures;
    }
}
