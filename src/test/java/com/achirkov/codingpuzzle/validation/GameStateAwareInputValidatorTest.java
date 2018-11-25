package com.achirkov.codingpuzzle.validation;

import com.achirkov.codingpuzzle.game.GameState;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class GameStateAwareInputValidatorTest {

    private GameState gameState;

    private List<String> availableOptions;

    private  Predicate<String> predicate;

    @Before
    public void setup() {
        gameState = GameState.MAIN_MENU;
        availableOptions = new ArrayList<>();
        availableOptions.add("1");
        availableOptions.add("2");
        predicate = GameContextAwareInputValidator.getValidationPredicate(gameState);
    }

    @Test
    public void parseCommand_success() {
        assertTrue(predicate.test("1"));
    }

    @Test
    public void parseCommand_fail_when_null() {
        assertFalse(predicate.test(null));
    }

    @Test
    public void parseCommand_fail_when_not_digits() {
        assertFalse(predicate.test("1a"));
    }

    @Test
    public void parseCommand_fail_when_blank_string() {
        assertFalse(predicate.test("  "));
    }

    @Test
    public void parseCommand_fail_when_negative() {
        assertFalse(predicate.test("-1"));
    }
}