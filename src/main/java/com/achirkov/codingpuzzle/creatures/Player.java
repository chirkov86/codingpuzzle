package com.achirkov.codingpuzzle.creatures;

import com.achirkov.codingpuzzle.positioning.Position;

public abstract class Player extends AbstractCreature implements Creature {

    private String characterClass;
    private int experience;
    private int money;

    Player(String characterClass, String name, Position position, int maxHitPoints, int loDamage, int hiDamage) {
        super(name, position, maxHitPoints, loDamage, hiDamage, 0, 0);
        this.characterClass = characterClass;
    }

    public String getCharacterClass() {
        return characterClass;
    }

    public void increaseExp(int reward) {
        experience += reward;
    }

    public void increaseMoney(int moneyReward) {
        money += moneyReward;
    }
}
