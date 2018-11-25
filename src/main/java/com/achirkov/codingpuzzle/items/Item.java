package com.achirkov.codingpuzzle.items;

import com.achirkov.codingpuzzle.positioning.Position;

public interface Item {
    Position getPosition();
    int getValue();
    String getName();
}
