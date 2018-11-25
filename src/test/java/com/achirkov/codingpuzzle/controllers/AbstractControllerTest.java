package com.achirkov.codingpuzzle.controllers;

import com.achirkov.codingpuzzle.exceptions.InvalidInputException;
import com.achirkov.codingpuzzle.game.GameContextManager;
import com.achirkov.codingpuzzle.game.GameState;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AbstractControllerTest {

    @InjectMocks
    private AbstractController mainMenuController = new MainMenuController();

    @Mock
    private GameContextManager gameContextManager;

    @Test
    public void processInput_selecting_options_in_main_menu_successful() {
        when(gameContextManager.getGameState()).thenReturn(GameState.MAIN_MENU);
        GameState state = mainMenuController.processInput("1", gameContextManager);
        assertNotNull(state);
        assertThat(state, is(GameState.CHARACTER_SELECTION));
    }

    @Test(expected = InvalidInputException.class)
    public void processInput_selecting_options_in_main_menu_fail() {
        when(gameContextManager.getGameState()).thenReturn(GameState.MAIN_MENU);
        GameState state = mainMenuController.processInput(" ", gameContextManager);
        assertNotNull(state);
        assertThat(state, is(GameState.CHARACTER_SELECTION));
    }
}