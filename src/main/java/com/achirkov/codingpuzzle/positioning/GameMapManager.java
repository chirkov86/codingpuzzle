package com.achirkov.codingpuzzle.positioning;

import com.achirkov.codingpuzzle.creatures.Creature;
import com.achirkov.codingpuzzle.exceptions.CreatureNotFoundException;
import com.achirkov.codingpuzzle.gamesetting.GameSetting;
import com.achirkov.codingpuzzle.items.Item;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Optional;

public class GameMapManager {

    private GameMap gameMap;
    private MapPresenter mapPresenter;
    private MapGenerator mapGenerator;

    public GameMapManager(int mapSize, @Nonnull GameSetting gameSetting) {
        this.gameMap = new GameMap(mapSize, new LinkedList<>(), new LinkedList<>(), Position.initial());
        this.mapPresenter = new CliMapPresenter();
        this.mapGenerator = new MapGenerator(gameSetting);
        mapGenerator.randomlyFillMapWithCreatures(this);
        mapGenerator.randomlyFillMapWithTreasures(this);
        mapGenerator.fillFogOfWar(this);
    }

    public GameMapManager(@Nonnull GameMap gameMap, @Nonnull GameSetting gameSetting) {
        this.gameMap = gameMap;
        this.mapPresenter = new CliMapPresenter();
        this.mapGenerator = new MapGenerator(gameSetting);
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
        adjacentPositions.forEach(position -> fogOfWar[position.getX()][position.getY()] = false);
    }

    /**
     * Assuming that a player can observe one adjacent cell
     * method should return up to 8 adjacent cells
     */
    private Collection<Position> getObservablePositionsAround() {
        Position playerPosition = getPlayerPosition();
        HashSet<Position> adjacentPositions = new HashSet<>();
        int dimension = getDimension();
        int y = playerPosition.getY();
        int x = playerPosition.getX();
        if (y - 1 >= 0) {
            adjacentPositions.add(Position.from(x, y - 1));
        }
        if (y - 1 >= 0 && x - 1 >= 0) {
            adjacentPositions.add(Position.from(x - 1, y - 1));
        }
        if (x - 1 >= 0) {
            adjacentPositions.add(Position.from(x - 1, y));
        }
        if (y + 1 < dimension && x - 1 >= 0) {
            adjacentPositions.add(Position.from(x - 1, y + 1));
        }
        if (y + 1 < dimension) {
            adjacentPositions.add(Position.from(x, y + 1));
        }
        if (y + 1 < dimension && x + 1 < dimension) {
            adjacentPositions.add(Position.from(x + 1, y + 1));
        }
        if (x + 1 < dimension) {
            adjacentPositions.add(Position.from(x + 1, y));
        }
        if (y - 1 >= 0 && x + 1 < dimension) {
            adjacentPositions.add(Position.from(x + 1, y - 1));
        }
        return adjacentPositions;
    }

    /**
     * @return true if it is a valid position within map boundaries, false otherwise
     */
    public boolean assertPositionIsValid(@Nonnull Position position) {
        return position.getX() < gameMap.getDimension()
                && position.getX() >= 0
                && position.getY() < gameMap.getDimension()
                && position.getY() >= 0;
    }

    /**
     * @return true if it is a free position, i.e. not occupied by a creature, false otherwise
     */
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

    /**
     * @return an enemy {@code Creature} at current player's position
     */
    public Creature getEnemyAtPlayerPosition() {
        return getEnemyAt(gameMap.getPlayerPosition())
                .orElseThrow(() -> new CreatureNotFoundException("Creature is not found at current player's position"));
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

    public boolean isTreasurePosition(int x, int y) {
        Position p = Position.from(x, y);
        return getItems().stream()
                .map(Item::getPosition)
                .anyMatch(p::equals);
    }

    private Collection<Item> getItems() {
        return gameMap.getTreasures();
    }

    /**
     * @return an {@code Optional<Item>} at a given position
     */
    public Optional<Item> getTreasureAt(Position position) {
        return getItems().stream()
                .filter(item -> item.getPosition().equals(position))
                .findFirst();
    }

    /**
     * @return an {@code Optional<Item>} at a given position and removes it from the map
     */
    public Optional<Item> takeTreasureAt(Position position) {
        final Optional<Item> optional = getTreasureAt(position);
        optional.ifPresent(item -> getItems().remove(item));
        return optional;
    }
}
