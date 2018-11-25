package com.achirkov.codingpuzzle.items;

import com.achirkov.codingpuzzle.positioning.Position;

public class Treasure extends AbstractItem implements Item {
    public Treasure(Position position) {
        this.name = "Treasure";
        this.value = 10;
        this.position = position;
    }
}
