package com.achirkov.codingpuzzle.positioning;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class GameMapManagerTest {

    private GameMapManager gameMapManager = new GameMapManager(3);

    @Test
    public void assertPositionIsValid() {
        Position invalidPosition1 = new Position(1, -1);
        Position invalidPosition2 = new Position(3, 0);
        assertFalse(gameMapManager.assertPositionIsValid(invalidPosition1));
        assertFalse(gameMapManager.assertPositionIsValid(invalidPosition2));
    }

    @Test
    public void assertPositionIsFree() {
        assertNotNull(gameMapManager.getEnemies());
        assertFalse(gameMapManager.getEnemies().isEmpty());

        Position monsterPosition = gameMapManager.getEnemies().iterator().next().getPosition();
        assertFalse(gameMapManager.assertPositionIsFree(monsterPosition));
    }
}