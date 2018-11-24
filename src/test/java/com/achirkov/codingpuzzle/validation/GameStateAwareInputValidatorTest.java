package com.achirkov.codingpuzzle.validation;

import com.achirkov.codingpuzzle.game.GameState;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GameStateAwareInputValidatorTest {

    @InjectMocks
    private GameContextAwareInputValidator gameContextAwareInputValidator ;
    @Mock
    private GameState GameState;

    private List<Integer> availableOptions;

    private  Predicate<String> predicate;

    @Before
    public void setup() {
        gameContextAwareInputValidator = new GameContextAwareInputValidator();

        availableOptions = new ArrayList<>();
        availableOptions.add(1);
        availableOptions.add(2);
        when(GameState.getStateMenu().getPossibleOptionCodes()).thenReturn(availableOptions);

        predicate = gameContextAwareInputValidator.getContextAwareValidationPredicate(GameState);
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