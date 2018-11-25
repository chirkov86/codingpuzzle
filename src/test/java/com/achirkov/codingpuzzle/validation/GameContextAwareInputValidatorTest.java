package com.achirkov.codingpuzzle.validation;

import org.junit.Test;

import java.util.function.Predicate;

import static com.achirkov.codingpuzzle.game.GameState.TRAVEL;
import static org.junit.Assert.*;

public class GameContextAwareInputValidatorTest {

    @Test
    public void getValidationPredicate() {
        Predicate<String> predicate = GameContextAwareInputValidator.getValidationPredicate(TRAVEL);
        assertTrue(predicate.test("w"));
        assertFalse(predicate.test("1"));
        assertFalse(predicate.test(" "));
    }
}