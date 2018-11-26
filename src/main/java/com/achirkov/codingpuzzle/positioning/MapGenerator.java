package com.achirkov.codingpuzzle.positioning;

import com.achirkov.codingpuzzle.creatures.Creature;
import com.achirkov.codingpuzzle.gamesetting.GameSetting;

import javax.annotation.Nonnull;
import java.util.Random;

public class MapGenerator {

    private final Random random;
    private final GameSetting gameSetting;

    public MapGenerator(@Nonnull GameSetting gameSetting) {
        this.random = new Random();
        this.gameSetting = gameSetting;
    }

    /**
     * Creates a set of creatures in a random not occupied cells
     */
    void randomlyFillMapWithCreatures(@Nonnull GameMapManager gameMapManager) {

        //TODO adapt method to scale up number of monsters with map size
        for (int i = 0; i < 2; i++) {
            randomlyFillMapWithCreature(gameMapManager);
        }
    }

    void randomlyFillMapWithTreasures(@Nonnull GameMapManager gameMapManager) {
        randomlyFillMapWithTreasure(gameMapManager);
        randomlyFillMapWithTreasure(gameMapManager);
    }

    /**
     * Creates a creature in a random not occupied cell
     */
    private void randomlyFillMapWithCreature(GameMapManager gameMapManager) {
        Position position = getRandomFreePosition(gameMapManager);
        gameMapManager.getEnemies().add(createRandomCreature(gameSetting, position));
    }

    /**
     * Creates a treasure in a random not occupied cell
     */
    private void randomlyFillMapWithTreasure(GameMapManager gameMapManager) {
        Position position = getRandomFreePosition(gameMapManager);
        gameMapManager.getGameMap().getTreasures().add(gameSetting.getItemFactory().apply(position));
    }

    /**
     * @return a random free, i.e. not occupied position
     */
    private Position getRandomFreePosition(GameMapManager gameMapManager) {
        int dimension = gameMapManager.getDimension();
        int x;
        int y;
        do {
            x = random.nextInt(dimension);
            y = random.nextInt(dimension);
        } while (gameMapManager.getEnemyAt(x, y).isPresent() || gameMapManager.isPlayerPosition(x, y));
        return Position.from(x, y);
    }

    // TODO optimize this, currently is stupid O(n^2) each time
    void fillFogOfWar(@Nonnull GameMapManager gameMapManager) {
        int dimension = gameMapManager.getGameMap().getDimension();
        boolean[][] fogOfWar = gameMapManager.getGameMap().getFogOfWar();
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                fogOfWar[i][j] = true;
            }
        }
        gameMapManager.clearFogOfWarInObservablePositions();
    }

    private Creature createRandomCreature(GameSetting gameSetting, Position position) {
        return gameSetting.getCreatureFactory().apply(position);
    }
}
