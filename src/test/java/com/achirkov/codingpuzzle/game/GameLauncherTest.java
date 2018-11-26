package com.achirkov.codingpuzzle.game;

import com.achirkov.codingpuzzle.io.ConsoleReader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GameLauncherTest {

    @InjectMocks
    private GameLauncher gameLauncher;

    @Mock
    private ConsoleReader consoleReader;

    @Test
    public void launchGame() {
        when(consoleReader.parseCommand(GameState.MAIN_MENU)).thenReturn("1").thenReturn("4");
        when(consoleReader.parseCommand(GameState.CHARACTER_SELECTION)).thenReturn("1");
        when(consoleReader.parseCommand(GameState.NAME_SELECTION)).thenReturn("Player1");
        when(consoleReader.parseCommand(GameState.TRAVEL)).thenReturn("W").thenReturn("5");
        when(consoleReader.parseCommand(GameState.BATTLE_CONFIRMATION)).thenReturn("2");
        gameLauncher.launchGame();
    }
}
