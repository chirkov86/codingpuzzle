package com.achirkov.codingpuzzle.positioning;

import com.achirkov.codingpuzzle.creatures.Creature;
import com.achirkov.codingpuzzle.exceptions.CreatureNotFound;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Optional;

public class GameMapManager {

    private GameMap gameMap;
    private MapPresenter mapPresenter;
    private MapGenerator mapGenerator;

    public GameMapManager(int dimension) {
        this.gameMap = new GameMap(dimension, new LinkedList<>(), Position.initial());
        this.mapPresenter = new CLIMapPresenter();
        this.mapGenerator = new MapGenerator();
        mapGenerator.randomlyFillMapWithCreatures(this);
        mapGenerator.fillFogOfWar(this);
    }

    public GameMapManager(GameMap gameMap) {
        this.gameMap = gameMap;
        this.mapPresenter = new CLIMapPresenter();
        this.mapGenerator = new MapGenerator();
    }

    public Collection<Creature> getEnemies() {
        return gameMap.getEnemies();
    }

    public Position getPlayerPosition() {
        return gameMap.getPlayerPosition();
    }

    public void setPlayerPosition(Position position) {
        gameMap.setPlayerPosition(position);
        clearFogOfWarInObservablePositions();
    }

    void clearFogOfWarInObservablePositions() {
        boolean[][] fogOfWar = gameMap.getFogOfWar();
        Collection<Position> adjacentPositions = getObservablePositionsAround();
        adjacentPositions.forEach(position -> {
            fogOfWar[position.getX()][position.getY()] = false;
        });
    }

    /**
     * Assuming that a player can observe one adjacent cell
     * method should return up to 8 adjacent cells
     */
    private Collection<Position> getObservablePositionsAround() {
        Position playerPosition = getPlayerPosition();
        HashSet<Position> set = new HashSet<>();
        int dimension = getDimension();
        int y = playerPosition.getY();
        int x = playerPosition.getX();
        if (y - 1 >= 0) {
            set.add(Position.from(x, y - 1));
        }
        if (y - 1 >= 0 && x - 1 >= 0) {
            set.add(Position.from(x - 1, y - 1));
        }
        if (x - 1 >= 0) {
            set.add(Position.from(x - 1, y));
        }
        if (y + 1 < dimension && x - 1 >= 0) {
            set.add(Position.from(x - 1, y + 1));
        }
        if (y + 1 < dimension) {
            set.add(Position.from(x, y + 1));
        }
        if (y + 1 < dimension && x + 1 < dimension) {
            set.add(Position.from(x + 1, y + 1));
        }
        if (x + 1 < dimension) {
            set.add(Position.from(x + 1, y));
        }
        if (y - 1 >= 0 && x + 1 < dimension) {
            set.add(Position.from(x + 1, y - 1));
        }
        return set;
    }

    public boolean assertPositionIsValid(Position position) {
        return position.getX() < gameMap.getDimension()
                && position.getX() >= 0
                && position.getY() < gameMap.getDimension()
                && position.getY() >= 0;
    }

    public boolean assertPositionIsFree(Position position) {
        return gameMap.getEnemies().stream()
                .filter(Creature::isAlive)
                .map(Creature::getPosition)
                .noneMatch(position1 -> position1.equals(position));
    }

    public void print() {
        mapPresenter.printMap(this);
    }

    boolean isPlayerPosition(int x, int y) {
        Position p = new Position(x, y);
        return p.equals(gameMap.getPlayerPosition());
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
        return gameMap.getEnemies().stream()
                .filter(creature -> creature.getPosition().equals(position))
                .findFirst();
    }

    /**
     * Returns an {@code Optional} creature at a given position if it is found or an empty {@code Optional} otherwise
     */
    public Optional<Creature> getEnemyAt(int x, int y) {
        return getEnemyAt(Position.from(x, y));
    }

    public Creature getEnemyAtCurrentPosition() {
        return getEnemyAt(gameMap.getPlayerPosition())
                .orElseThrow(() -> new CreatureNotFound("Creature not found at current position"));
    }

    public int getDimension() {
        return gameMap.getDimension();
    }

    public GameMap getGameMap() {
        return gameMap;
    }

    public boolean isPositionExplored(int x, int y) {
        return !getGameMap().getFogOfWar()[x][y];
    }
}
