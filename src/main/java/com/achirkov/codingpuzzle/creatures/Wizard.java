package com.achirkov.codingpuzzle.creatures;

import com.achirkov.codingpuzzle.positioning.Position;

public class Wizard extends Player implements Creature {

    public Wizard(String name, Position position) {
        super(name, "Wizard", position, 75, 20, 30);
    }
}
