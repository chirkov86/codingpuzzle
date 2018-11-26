package com.achirkov.codingpuzzle.io;

import com.achirkov.codingpuzzle.game.GameState;
import com.achirkov.codingpuzzle.logger.Logger;
import com.achirkov.codingpuzzle.validation.GameContextAwareInputValidator;

import javax.annotation.Nonnull;
import java.util.Scanner;
import java.util.function.Predicate;

public class ConsoleReader {

    private final static String THIS_IS_NOT_A_VALID_OPTION = "This is not a valid option!";
    private final static Logger LOGGER = Logger.getInstance();
    private final Scanner sc = new Scanner(System.in);

    public String parseCommand(@Nonnull GameState GameState) {

        String input = sc.nextLine();

        Predicate<String> isValidInput = GameContextAwareInputValidator.getValidationPredicate(GameState);

        while (!isValidInput.test(input)) {
            System.out.println(THIS_IS_NOT_A_VALID_OPTION);
            input = sc.nextLine();
        }

        LOGGER.debug("User picked up option " + input);
        return input;
    }

}
