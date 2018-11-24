package com.achirkov.codingpuzzle.io;

import com.achirkov.codingpuzzle.game.GameState;
import com.achirkov.codingpuzzle.logger.Logger;
import com.achirkov.codingpuzzle.menus.menuitems.MenuOption;
import com.achirkov.codingpuzzle.validation.GameContextAwareInputValidator;

import java.util.Scanner;
import java.util.function.Predicate;

public class ConsoleReader {

    private final static String THIS_IS_NOT_A_VALID_OPTION = "This is not a valid option!";
    private final static Logger LOGGER = Logger.getInstance();
    private final Scanner sc = new Scanner(System.in);
    private GameContextAwareInputValidator inputValidator = new GameContextAwareInputValidator();

    public MenuOption parseCommand(GameState GameState) {

        String input = sc.nextLine();

        Predicate<String> isValidInput = inputValidator.getContextAwareValidationPredicate(GameState);

        while (!isValidInput.test(input)) {
            System.out.println(THIS_IS_NOT_A_VALID_OPTION);
            input = sc.nextLine();
        }

        LOGGER.debug("User picked up option " + input);
        return commandFrom(input, GameState);
    }

    private MenuOption commandFrom(String input, GameState gameState) {
        LOGGER.debug("Mapping input code " + input + " to command for state " + gameState.toString());
        return gameState.getStateMenu().getOptionFromCode(Integer.parseInt(input));
    }
}
