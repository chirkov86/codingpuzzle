package com.achirkov.codingpuzzle.positioning;

import com.achirkov.codingpuzzle.creatures.Creature;

import java.io.Serializable;
import java.util.Collection;

/**
 * Data object class
 */
public class GameMap implements Serializable {
    private int dimension;
    private Collection<Creature> enemies;
    private Position playerPosition;

    public GameMap(int dimension, Collection<Creature> enemies, Position playerPosition) {
        this.dimension = dimension;
        this.enemies = enemies;
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
}
