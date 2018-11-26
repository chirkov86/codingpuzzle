package com.achirkov.codingpuzzle.controllers;

import com.achirkov.codingpuzzle.creatures.Knight;
import com.achirkov.codingpuzzle.creatures.Skeleton;
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

import static com.achirkov.codingpuzzle.game.GameState.TRAVEL;
import static com.achirkov.codingpuzzle.menus.menuoptions.BattleMenuOptions.ATTACK;
import static com.achirkov.codingpuzzle.menus.menuoptions.BattleMenuOptions.FLEE;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BattleControllerTest {
    @InjectMocks
    private BattleController battleController;

    @Mock
    private GameContextManager gameContextManager;

    @Mock
    private GameMapManager gameMapManager;

    @Mock
    private Position position;

    @Before
    public void setUp() {
        when(gameContextManager.getGameMapManager()).thenReturn(gameMapManager);
        when(gameMapManager.getEnemyAtPlayerPosition()).thenReturn(new Skeleton(position));
        when(gameContextManager.getPlayer()).thenReturn(new Knight(position));
    }

    @Test
    public void processCommand_attack() {
        battleController.processCommand(ATTACK, gameContextManager);
    }

    @Test
    public void processCommand_flee() {
        GameState gameState = battleController.processCommand(FLEE, gameContextManager);

        verify(gameContextManager, times(1)).getPositionForFlee();
        verify(gameContextManager, times(1)).setPositionForFlee(null);
        assertEquals(TRAVEL, gameState);
    }
}
