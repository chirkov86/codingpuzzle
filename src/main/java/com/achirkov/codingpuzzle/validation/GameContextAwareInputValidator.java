package com.achirkov.codingpuzzle.validation;

import com.achirkov.codingpuzzle.game.GameState;

import java.util.function.Predicate;
import java.util.regex.Pattern;

public class GameContextAwareInputValidator {

    private static final Pattern NUMERIC_PATTERN = Pattern.compile("[0-9]+");
    /**
     * Checks if input is not empty alphanumeric with no spaces
     */
    private static final Pattern ALPHANUMERIC_PATTERN = Pattern.compile("[a-zA-Z0-9]+");

    private static final Predicate<String> IS_NOT_BLANK = s -> s != null && !s.trim().isEmpty();
    private static final Predicate<String> IS_ALPHANUMERIC =
            s -> IS_NOT_BLANK.test(s) && ALPHANUMERIC_PATTERN.matcher(s).matches();
    private static final Predicate<String> IS_DIGITS_ONLY =
            s -> IS_NOT_BLANK.test(s) && NUMERIC_PATTERN.matcher(s).matches();

    /**
     * Checks input string against current GameState, i.e. current menu.
     * Each menu contains a list of possible options mapped to corresponding input strings.
     * Input string must match at least one from the list.
     * <p>
     * If current state has no menu, then Input string must match a non-empty alphanumeric regexp.
     */
    public static Predicate<String> getValidationPredicate(GameState GameState) {
        if (GameState.getStateMenu() != null && GameState.getStateMenu().getPossibleOptionInputs() != null) {
            return input -> IS_NOT_BLANK.test(input)
                    && GameState.getStateMenu().getPossibleOptionInputs().stream().anyMatch(input::equalsIgnoreCase);
        } else return IS_ALPHANUMERIC;
    }
}
