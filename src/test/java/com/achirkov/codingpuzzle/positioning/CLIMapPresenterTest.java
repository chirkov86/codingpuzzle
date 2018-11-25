package com.achirkov.codingpuzzle.positioning;

import org.junit.Before;
import org.junit.Test;

public class CLIMapPresenterTest {

    private CLIMapPresenter cliMapPresenter;
    private GameMapManager gameMapManager;

    @Before
    public void setUp() throws Exception {
        cliMapPresenter = new CLIMapPresenter();
        gameMapManager = new GameMapManager(2);
    }

    @Test
    public void printMap() {
        cliMapPresenter.printMap(gameMapManager);
    }
}