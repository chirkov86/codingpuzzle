package com.achirkov.codingpuzzle.creatures;

import com.achirkov.codingpuzzle.exceptions.CreatureIsDead;
import com.achirkov.codingpuzzle.positioning.Position;

import java.io.Serializable;
import java.util.Random;

public abstract class AbstractCreature implements Creature, Serializable {

    private static final Random random = new Random();
    private String name;
    private Position position;
    private int currentHitPoints;
    private int maxHitPoints;
    private int loDamage;
    private int hiDamage;

    private boolean isAlive;

    private int expReward;
    private int moneyReward;

    AbstractCreature(String name, Position position, int maxHitPoints, int loDamage, int hiDamage, int expReward,
                            int moneyReward) {
        this.isAlive = true;
        this.name = name;
        this.position = position;
        this.maxHitPoints = maxHitPoints;
        this.currentHitPoints = maxHitPoints;
        this.loDamage = loDamage;
        this.hiDamage = hiDamage;
        this.expReward = expReward;
        this.moneyReward = moneyReward;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public int attack() {
        if (!isAlive()) {
            throw new CreatureIsDead("This creature can not attack because it is dead!");
        }
        return random.nextInt(hiDamage - loDamage + 1) + loDamage;
    }

    @Override
    public int getCurrentHitPoints() {
        return currentHitPoints;
    }

    @Override
    public void decreaseHitPointsBy(int hp) {
        currentHitPoints -= hp;
        if (currentHitPoints <= 0) {
            isAlive = false;
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isAlive() {
        return isAlive;
    }

    @Override
    public int getExpReward() {
        return expReward;
    }

    @Override
    public int getMoneyReward() {
        return moneyReward;
    }

    @Override
    public String getDamageInfo() {
        return loDamage + "-" + hiDamage;
    }

    public void setName(String name) {
        this.name = name;
    }

}
