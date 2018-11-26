package com.achirkov.codingpuzzle.controllers;

import com.achirkov.codingpuzzle.exceptions.InvalidInputException;
import com.achirkov.codingpuzzle.game.GameContextManager;
import com.achirkov.codingpuzzle.game.GameState;
import com.achirkov.codingpuzzle.gamesetting.GameSetting;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class AbstractControllerTest {

    private AbstractController mainMenuController = new MainMenuController();

    private GameContextManager gameContextManager;

    @Before
    public void setUp() throws Exception {
        gameContextManager = new GameContextManager(GameSetting.DUNGEON);
    }

    @Test
    public void processInput_selecting_options_in_main_menu_successful() {
        GameState state = mainMenuController.processInput("1", gameContextManager);
        assertNotNull(state);
        assertThat(state, is(GameState.CHARACTER_SELECTION));
    }

    @Test(expected = InvalidInputException.class)
    public void processInput_selecting_options_in_main_menu_fail() {
        GameState state = mainMenuController.processInput(" ", gameContextManager);
        assertNotNull(state);
        assertThat(state, is(GameState.CHARACTER_SELECTION));
    }
}
