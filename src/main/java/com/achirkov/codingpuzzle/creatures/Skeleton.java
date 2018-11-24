package com.achirkov.codingpuzzle.creatures;

import com.achirkov.codingpuzzle.positioning.Position;

public class Skeleton extends AbstractCreature implements Creature {

    public Skeleton(Position position) {
        super("Skeleton", position, 50, 10, 16, 100, 5);
    }

}
