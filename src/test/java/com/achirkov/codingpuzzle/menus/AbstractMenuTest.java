package com.achirkov.codingpuzzle.menus;

import com.achirkov.codingpuzzle.game.GameContextManager;
import com.achirkov.codingpuzzle.gamesetting.GameSetting;
import com.achirkov.codingpuzzle.menus.menuoptions.MenuOption;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static com.achirkov.codingpuzzle.menus.menuoptions.MainMenuOptions.START_NEW_GAME;
import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;

public class AbstractMenuTest {

    private AbstractMenu menu = new MainMenu("test");
    private GameContextManager gameContextManager = new GameContextManager(GameSetting.DUNGEON);

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void show() {
        menu.show(gameContextManager);
    }

    @Test
    public void getPossibleOptionInputs() {
        List<String> possibleOptionInputs = menu.getPossibleOptionInputs();
        assertNotNull(possibleOptionInputs);
        assertFalse(possibleOptionInputs.isEmpty());
    }

    @Test
    public void getOptionFromInput() {
        MenuOption option = menu.getOptionFromInput("1");
        assertNotNull(option);
        assertEquals(option, START_NEW_GAME);
    }
}