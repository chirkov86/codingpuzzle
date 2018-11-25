package com.achirkov.codingpuzzle.creatures;

import com.achirkov.codingpuzzle.positioning.Position;

public class Knight extends Player implements Creature {

    public Knight(String name, Position position) {
        super("Knight", name, position, 10, 15, 23);
    }
}
