package com.achirkov.codingpuzzle.positioning;

import com.achirkov.codingpuzzle.creatures.Skeleton;

import java.util.Random;

public class MapGenerator {

    private final Random random;

    public MapGenerator() {
        this.random = new Random();
    }

    void randomlyFillMapWithCreatures(GameMapManager gameMapManager) {

        //TODO adapt method to scale up number of monsters with map size
        for (int i = 0; i < 2; i++) {
            randomlyFillMapWithCreature(gameMapManager);
        }
    }

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

}
