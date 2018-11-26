package com.achirkov.codingpuzzle.positioning;

import com.achirkov.codingpuzzle.gamesetting.GameSetting;
import org.junit.Before;
import org.junit.Test;

public class CliMapPresenterTest {

    private CliMapPresenter cliMapPresenter;
    private GameMapManager gameMapManager;

    @Before
    public void setUp() throws Exception {
        cliMapPresenter = new CliMapPresenter();
        gameMapManager = new GameMapManager(2, GameSetting.DUNGEON);
    }

    @Test
    public void printMap() {
        cliMapPresenter.printMap(gameMapManager);
    }
}
