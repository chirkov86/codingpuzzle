package com.achirkov.codingpuzzle.positioning;

import com.achirkov.codingpuzzle.creatures.Creature;
import com.achirkov.codingpuzzle.exceptions.CreatureNotFound;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Optional;

public class GameMap {

    private int dimension;
    private Collection<Creature> enemies;
    private Position playerPosition;
    private MapPresenter mapPresenter;
    private MapGenerator mapGenerator;

    public GameMap(int dimension) {
        this.dimension = dimension;
        this.playerPosition = new Position(0, 0);
        this.enemies = new LinkedList<>();
        this.mapPresenter = new CLIMapPresenter();
        this.mapGenerator = new MapGenerator();
        mapGenerator.randomlyFillMapWithCreatures(this);
    }

    public Collection<Creature> getEnemies() {
        return enemies;
    }

    public Position getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(Position playerPosition) {
        this.playerPosition = playerPosition;
    }

    public boolean assertPositionIsValid(Position position) {
        return position.getX() < this.dimension
                && position.getX() >= 0
                && position.getY() < this.dimension
                && position.getY() >= 0;
    }

    public boolean assertPositionIsFree(Position position) {
        return enemies.stream()
                .map(Creature::getPosition)
                .noneMatch(position1 -> position1.equals(position));
    }

    public void print() {
        mapPresenter.printMap(this);
    }

    boolean isPlayerPosition(int x, int y) {
        Position p = new Position(x, y);
        return p.equals(playerPosition);
    }

    boolean isMonsterPosition(int x, int y) {
        Position p = new Position(x, y);
        return getEnemies().stream()
                .map(Creature::getPosition)
                .anyMatch(p::equals);
    }

    /**
     * Returns an {@code Optional} creature at a given position if it is found or an empty {@code Optional} otherwise
     */
    public Optional<Creature> getEnemyAt(Position position) {
        return enemies.stream()
                .filter(creature -> creature.getPosition().equals(position))
                .findFirst();
    }

    /**
     * Returns an {@code Optional} creature at a given position if it is found or an empty {@code Optional} otherwise
     */
    public Optional<Creature> getEnemyAt(int x, int y) {
        return getEnemyAt(Position.from(x,y));
    }

    public Creature getEnemyAtCurrentPosition() {
        return getEnemyAt(playerPosition)
                .orElseThrow(() -> new CreatureNotFound("Creature not found at current position"));
    }


    public int getDimension() {
        return dimension;
    }

}
