package com.achirkov.codingpuzzle.game;

import com.achirkov.codingpuzzle.creatures.Knight;
import com.achirkov.codingpuzzle.creatures.Player;
import com.achirkov.codingpuzzle.positioning.GameMap;
import com.achirkov.codingpuzzle.positioning.Position;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class GameContextSerializerTest {

    private GameContextSerializer gameContextSerializer;
    private GameContextHolder gameContextHolder;

    @Before
    public void setUp() throws Exception {
        gameContextSerializer = new GameContextSerializer();
        Player player = new Knight("testName", Position.initial());
        GameMap gameMap = new GameMap(2);
        gameContextHolder = GameContextHolder.from(player, gameMap);
    }

    @Test
    public void serializeContext() throws IOException {
        gameContextSerializer.serializeContext(gameContextHolder);
    }
}