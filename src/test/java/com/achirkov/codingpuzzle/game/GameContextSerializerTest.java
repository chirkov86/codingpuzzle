package com.achirkov.codingpuzzle.game;

import com.achirkov.codingpuzzle.creatures.Knight;
import com.achirkov.codingpuzzle.creatures.Player;
import com.achirkov.codingpuzzle.positioning.GameMapManager;
import com.achirkov.codingpuzzle.positioning.Position;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class GameContextSerializerTest {

    private GameContextSerializer gameContextSerializer;
    private GameContextHolder gameContextHolder;
    private Player player;
    private GameMapManager gameMapManager;

    @Before
    public void setUp() throws Exception {
        gameContextSerializer = new GameContextSerializer();
        player = new Knight("testName", Position.initial());
        gameMapManager = new GameMapManager(5);
        gameContextHolder = new GameContextHolder(player, gameMapManager.getGameMap());
    }

    @Test
    public void serializeContext() {
        gameContextSerializer.serializeContext(gameContextHolder);
    }

    @Test
    public void deserialize() throws ClassNotFoundException {
        gameContextSerializer.serializeContext(gameContextHolder);

        GameContextHolder contextHolder = gameContextSerializer.deserializeContext();
        System.out.println();
        assertNotNull(contextHolder);
        assertNotNull(contextHolder.getGameMap());
        assertEquals(contextHolder.getGameMap().getPlayerPosition(), gameMapManager.getPlayerPosition());
        assertNotNull(contextHolder.getPlayer());
    }
}