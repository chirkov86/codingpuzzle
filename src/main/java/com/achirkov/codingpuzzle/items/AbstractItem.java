package com.achirkov.codingpuzzle.items;

import com.achirkov.codingpuzzle.positioning.Position;

import java.io.Serializable;

public class AbstractItem implements Item, Serializable {
    public static final long serialVersionUID = 42L;
    String name;
    int value;
    Position position;

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public String getName() {
        return name;
    }
}
