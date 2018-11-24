package com.achirkov.codingpuzzle.positioning;

import com.achirkov.codingpuzzle.creatures.Skeleton;

import java.util.Random;

public class MapGenerator {

    private final Random random;

    public MapGenerator() {
        this.random = new Random();
    }

    void randomlyFillMapWithCreatures(GameMap gameMap) {

        //TODO adapt method to scale up number of monsters with map size
        for (int i = 0; i < 2; i++) {
            randomlyFillMapWithCreature(gameMap);
        }
    }

    private void randomlyFillMapWithCreature(GameMap gameMap) {
        int dimension = gameMap.getDimension();
        Position position;
        int x;
        int y;
        do {
            x = random.nextInt(dimension);
            y = random.nextInt(dimension);
            position = new Position(x, y);
        } while (gameMap.isMonsterPosition(x, y) || gameMap.isPlayerPosition(x, y));

        gameMap.getEnemies().add(new Skeleton(position));
    }

}
