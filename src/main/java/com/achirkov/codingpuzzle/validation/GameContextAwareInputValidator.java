package com.achirkov.codingpuzzle.validation;

import com.achirkov.codingpuzzle.game.GameState;

import java.util.function.Predicate;
import java.util.regex.Pattern;

public class GameContextAwareInputValidator {


    private static final Pattern NUMERIC_PATTERN = Pattern.compile("[0-9]+");
    private static final Predicate<String> isNotBlank = s -> s != null && !s.trim().isEmpty();
    private static final Predicate<String> isDigitsOnly = s -> s != null && NUMERIC_PATTERN.matcher(s).matches();

    public static Predicate<String> getBasicValidationPredicate() {
        return isNotBlank.and(isDigitsOnly);
    }

    public Predicate<String> getContextAwareValidationPredicate(GameState GameState) {
        final Predicate<String> contextAwarePredicate =
                option -> GameState.getStateMenu().getPossibleOptionCodes().contains(Integer.parseInt(option));

        return getBasicValidationPredicate().and(contextAwarePredicate);
    }
}
