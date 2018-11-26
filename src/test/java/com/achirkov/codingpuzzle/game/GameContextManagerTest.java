package com.achirkov.codingpuzzle.game;

import com.achirkov.codingpuzzle.creatures.Knight;
import com.achirkov.codingpuzzle.gamesetting.GameSetting;
import com.achirkov.codingpuzzle.positioning.Position;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class GameContextManagerTest {

    private GameContextManager gameContextManager;

    @Before
    public void setUp() throws Exception {
        gameContextManager = new GameContextManager(GameSetting.DUNGEON);
        gameContextManager.setPlayer(new Knight(Position.initial()));
    }

    @After
    public void tearDown() throws Exception {
        File file = new File("savegames/savegame");
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    public void save() {
        gameContextManager.save();
    }

    @Test
    public void load() {
        gameContextManager.save();
        gameContextManager.load();
    }

    @Test
    public void init() {
        gameContextManager.init();
    }
}
