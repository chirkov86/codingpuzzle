package com.achirkov.codingpuzzle.controllers;

import com.achirkov.codingpuzzle.creatures.Creature;
import com.achirkov.codingpuzzle.creatures.Player;
import com.achirkov.codingpuzzle.game.GameContextManager;
import com.achirkov.codingpuzzle.game.GameState;
import com.achirkov.codingpuzzle.menus.BattleMenu;
import com.achirkov.codingpuzzle.menus.menuitems.BattleMenuOptions;
import com.achirkov.codingpuzzle.menus.menuitems.MenuOption;

import static com.achirkov.codingpuzzle.game.GameState.*;

public class BattleController extends AbstractController implements StateController {

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
        System.out.println("You have cowardly fled from the battle");
        gameContextManager.getGameMap().setPlayerPosition(gameContextManager.getPositionForFlee());
        gameContextManager.setPositionForFlee(null);
        return TRAVEL;
    }

    private GameState tryAttack(GameContextManager gameContextManager) {
        Creature enemy = gameContextManager.getGameMap().getEnemyAtCurrentPosition();
        Player player = gameContextManager.getPlayer();

        int playerAttack = player.attack();
        enemy.decreaseHitPointsBy(playerAttack);
        System.out.println("Player attacked a " + enemy.getName() + " for " + playerAttack + " hitpoints");

        if (enemy.isAlive()) {
            int enemyAttack = enemy.attack();
            player.decreaseHitPointsBy(enemyAttack);
            System.out.println(enemy.getName() + " attacked a player for " + enemyAttack + " hitpoints");
            if (player.isAlive()) {
                System.out.println("Next round!");
                return BATTLE;
            } else {
                System.out.println("Player has died");
                return DEATH;
            }
        } else {
            System.out.println(enemy.getName() + " has died");
            return VICTORY;
        }
    }
}
