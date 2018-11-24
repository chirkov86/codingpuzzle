package com.achirkov.codingpuzzle.creatures;

import com.achirkov.codingpuzzle.positioning.Position;

public interface Creature {
    Position getPosition();
    int attack();
    int getCurrentHitPoints();
    void decreaseHitPointsBy(int hp);
    boolean isAlive();
    int getExpReward();
    int getMoneyReward();
    String getName();
    String getDamageInfo();
}
