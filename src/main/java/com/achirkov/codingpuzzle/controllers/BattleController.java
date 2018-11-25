package com.achirkov.codingpuzzle.controllers;

import com.achirkov.codingpuzzle.creatures.Creature;
import com.achirkov.codingpuzzle.creatures.Player;
import com.achirkov.codingpuzzle.game.GameContextManager;
import com.achirkov.codingpuzzle.game.GameState;
import com.achirkov.codingpuzzle.menus.BattleMenu;
import com.achirkov.codingpuzzle.menus.menuoptions.BattleMenuOptions;
import com.achirkov.codingpuzzle.menus.menuoptions.MenuOption;

import static com.achirkov.codingpuzzle.game.GameState.*;
import static com.achirkov.codingpuzzle.io.ColorCodes.*;

public class BattleController extends AbstractController {

    public BattleController() {
        menu = new BattleMenu();
    }

    @Override
    public GameState processCommand(MenuOption command, GameContextManager gameContextManager) {

        switch ((BattleMenuOptions) command) {
            case ATTACK:
                return tryAttack(gameContextManager);
            case FLEE:
                return fleeToPrevPosition(gameContextManager);
            default:
                return MAIN_MENU;
        }
    }

    private GameState fleeToPrevPosition(GameContextManager gameContextManager) {
        //TODO add penalty
        System.out.println("You have cowardly fled from the battle");
        gameContextManager.getGameMapManager().setPlayerPosition(gameContextManager.getPositionForFlee());
        gameContextManager.setPositionForFlee(null);
        return TRAVEL;
    }

    private GameState tryAttack(GameContextManager gameContextManager) {
        Creature enemy = gameContextManager.getGameMapManager().getEnemyAtCurrentPosition();
        Player player = gameContextManager.getPlayer();
        StringBuilder battleLog;

        int playerAttack = player.attack();
        enemy.decreaseHitPointsBy(playerAttack);
        battleLog = new StringBuilder(ANSI_BLUE)
                .append("Player attacked a ")
                .append(enemy.getName())
                .append(" for ")
                .append(playerAttack)
                .append(" hitpoints")
                .append(ANSI_RESET);
        System.out.println(battleLog);

        if (enemy.isAlive()) {
            int enemyAttack = enemy.attack();
            player.decreaseHitPointsBy(enemyAttack);
            battleLog = new StringBuilder(ANSI_RED)
                    .append(enemy.getName())
                    .append(" attacked a player for ")
                    .append(enemyAttack)
                    .append(" hitpoints")
                    .append(ANSI_RESET);
            System.out.println(battleLog);
            if (player.isAlive()) {
                System.out.println("Next round!");
                return BATTLE;
            } else {
                battleLog = new StringBuilder().append(ANSI_RED).append("Player has died").append(ANSI_RESET);
                System.out.println(battleLog);
                return DEATH;
            }
        } else {
            battleLog = new StringBuilder()
                    .append(enemy.getName())
                    .append(" has died");
            System.out.println(battleLog);
            return VICTORY;
        }
    }
}
