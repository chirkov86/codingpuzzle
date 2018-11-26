package com.achirkov.codingpuzzle.gamesetting;

import com.achirkov.codingpuzzle.creatures.Creature;
import com.achirkov.codingpuzzle.creatures.Orc;
import com.achirkov.codingpuzzle.creatures.Skeleton;
import com.achirkov.codingpuzzle.items.Item;
import com.achirkov.codingpuzzle.items.Treasure;
import com.achirkov.codingpuzzle.positioning.Position;

import java.io.Serializable;
import java.util.function.Function;

/**
 * {@code GameSetting} is an extension point to introduce new game topic / game stories.
 * Each game setting provides a suppliers for enemies, items and heroes(todo).
 */
public enum GameSetting implements Serializable {
    DUNGEON {
        @Override
        public Function<Position, Creature> getCreatureFactory() {
            return Skeleton::new;
        }

        @Override
        public Function<Position, Item> getItemFactory() {
            return Treasure::new;
        }

        @Override
        public String getName() {
            return "Dungeon explorer adventure";
        }
    },
    LOTR {
        @Override
        public Function<Position, Creature> getCreatureFactory() {
            return Orc::new;
        }

        @Override
        public Function<Position, Item> getItemFactory() {
            return Treasure::new;
        }

        @Override
        public String getName() {
            return "Lords of the Rings Adventure";
        }
    },
    ;

    /**
     * @return a {@code Function} to create a Creature from a Position
     */
    public abstract Function<Position, Creature> getCreatureFactory();
    /**
     * @return a {@code Function} to create an Item from a Position
     */
    public abstract Function<Position, Item> getItemFactory();
    public abstract String getName();}
