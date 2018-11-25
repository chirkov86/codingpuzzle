package com.achirkov.codingpuzzle.controllers;

import com.achirkov.codingpuzzle.game.GameContextManager;
import com.achirkov.codingpuzzle.game.GameState;
import com.achirkov.codingpuzzle.positioning.GameMapManager;
import com.achirkov.codingpuzzle.positioning.Position;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static com.achirkov.codingpuzzle.game.GameState.BATTLE;
import static com.achirkov.codingpuzzle.game.GameState.TRAVEL;
import static com.achirkov.codingpuzzle.menus.menuoptions.BattleConfirmationMenuOptions.DO_NOT_ENGAGE;
import static com.achirkov.codingpuzzle.menus.menuoptions.BattleConfirmationMenuOptions.ENGAGE;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BattleConfirmationControllerTest {

    @InjectMocks
    private BattleConfirmationController battleConfirmationController;

    @Mock
    private GameContextManager gameContextManager;

    @Mock
    private Position position;

    @Mock
    private GameMapManager gameMapManager;

    @Before
    public void setUp() {
        battleConfirmationController = new BattleConfirmationController();
        when(gameContextManager.getPositionForAttack()).thenReturn(position);
        when(gameContextManager.getGameMapManager()).thenReturn(gameMapManager);
    }

    @Test
    public void processCommand_engage() {
        GameState gameState = battleConfirmationController.processCommand(ENGAGE, gameContextManager);

        verify(gameContextManager, times(1)).setPositionForAttack(null);
        verify(gameMapManager, times(1)).setPlayerPosition(position);
        assertEquals(BATTLE, gameState);
    }

    @Test
    public void processCommand_do_not_engage() {
        GameState gameState = battleConfirmationController.processCommand(DO_NOT_ENGAGE, gameContextManager);

        verify(gameContextManager, times(1)).setPositionForAttack(null);
        verify(gameContextManager, times(1)).setPositionForFlee(null);
        assertEquals(TRAVEL, gameState);
    }
}