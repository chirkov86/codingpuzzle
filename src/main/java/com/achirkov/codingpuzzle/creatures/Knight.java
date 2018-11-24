package com.achirkov.codingpuzzle.creatures;

import com.achirkov.codingpuzzle.positioning.Position;

public class Knight extends Player implements Creature {

    public Knight(String name, Position position) {
        super(name, "Knight", position, 100, 15, 23);
    }
}
