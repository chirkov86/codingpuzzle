package com.achirkov.codingpuzzle.positioning;

import java.io.Serializable;
import java.util.Objects;

/**
 * Data object class.
 * Effectively immutable.
 * Is used to save game.
 */
public class Position implements Serializable  {

    public static final long serialVersionUID = 42L;
    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /**
     * @return a new {@code Position} instance which is adjacent to this on the given direction
     */
    public Position getNewPositionToThe(Direction direction) {
        switch (direction) {
            case NORTH:
                return new Position(this.x, this.y + 1);
            case WEST:
                return new Position(this.x - 1, this.y);
            case SOUTH:
                return new Position(this.x, this.y - 1);
            case EAST:
                return new Position(this.x + 1, this.y);
            default:
                return new Position(this.x, this.y);
        }
    }

    public static Position from(int x, int y) {
        return new Position(x, y);
    }

    public static Position initial() {
        return new Position(0, 0);
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + ']';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x &&
                y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
