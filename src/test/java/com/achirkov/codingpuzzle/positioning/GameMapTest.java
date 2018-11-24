package com.achirkov.codingpuzzle.positioning;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class GameMapTest {

    private GameMap gameMap = new GameMap(3);

    @Test
    public void assertPositionIsValid() {
        Position invalidPosition1 = new Position(1, -1);
        Position invalidPosition2 = new Position(3, 0);
        assertFalse(gameMap.assertPositionIsValid(invalidPosition1));
        assertFalse(gameMap.assertPositionIsValid(invalidPosition2));
    }

    @Test
    public void assertPositionIsFree() {
        assertNotNull(gameMap.getEnemies());
        assertFalse(gameMap.getEnemies().isEmpty());

        Position monsterPosition = gameMap.getEnemies().iterator().next().getPosition();
        assertFalse(gameMap.assertPositionIsFree(monsterPosition));
    }
}