package com.achirkov.codingpuzzle.creatures;

import com.achirkov.codingpuzzle.positioning.Position;

public class Orc extends AbstractCreature implements Creature {

    public Orc(Position position) {
        super("Orc", position, 50, 10, 16, 100, 5);
    }
}
