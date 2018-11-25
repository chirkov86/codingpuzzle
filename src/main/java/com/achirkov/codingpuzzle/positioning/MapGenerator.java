package com.achirkov.codingpuzzle.positioning;

import com.achirkov.codingpuzzle.creatures.Skeleton;

import java.util.Random;

public class MapGenerator {

    private final Random random;

    public MapGenerator() {
        this.random = new Random();
    }

    /**
     * Creates a set of creatures in a random not occupied cells
     */
    void randomlyFillMapWithCreatures(GameMapManager gameMapManager) {

        //TODO adapt method to scale up number of monsters with map size
        for (int i = 0; i < 2; i++) {
            randomlyFillMapWithCreature(gameMapManager);
        }
    }

    /**
     * Creates a creature in a random not occupied cell
     */
    private void randomlyFillMapWithCreature(GameMapManager gameMapManager) {
        int dimension = gameMapManager.getDimension();
        Position position;
        int x;
        int y;
        do {
            x = random.nextInt(dimension);
            y = random.nextInt(dimension);
            position = new Position(x, y);
        } while (gameMapManager.isMonsterPosition(x, y) || gameMapManager.isPlayerPosition(x, y));

        gameMapManager.getEnemies().add(new Skeleton(position));
    }

    // TODO optimize this, currently is stupid O(n^2) each time
    public void fillFogOfWar(GameMapManager gameMapManager) {
        int dimension = gameMapManager.getGameMap().getDimension();
        boolean[][] fogOfWar = gameMapManager.getGameMap().getFogOfWar();
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                fogOfWar[i][j] = true;
            }
        }
        gameMapManager.clearFogOfWarInObservablePositions();
    }
}
