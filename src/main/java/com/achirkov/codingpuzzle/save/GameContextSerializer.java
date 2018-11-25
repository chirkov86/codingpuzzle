package com.achirkov.codingpuzzle.save;

import com.achirkov.codingpuzzle.exceptions.SaveGameNotFoundException;
import com.achirkov.codingpuzzle.logger.Logger;

import java.io.*;

/**
 * Saves game state enclosed inside {@code GameContextHolder} to filesystem.
 * Because it uses simple byte stream serialization of the class objects,
 * deserialization may fail if corresponding classes have changed.
 */
public class GameContextSerializer {
    private static final Logger LOGGER = Logger.getInstance();

    public void serializeContext(GameContextHolder gameContextHolder) {
        File dir = new File("savegames");
        if (!dir.exists()) {
            dir.mkdir();
        }
        try (FileOutputStream fos = new FileOutputStream(new File("savegames/savegame"));
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(gameContextHolder);
        } catch (IOException e) {
            LOGGER.debug(e.getMessage());
        }
    }

    public GameContextHolder deserializeContext() throws SaveGameNotFoundException {
        File file = new File("savegames/savegame");
        GameContextHolder contextHolder = null;

        if (!file.exists()) {
            throw new SaveGameNotFoundException("");
        }
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            contextHolder = (GameContextHolder) ois.readObject();
        } catch (ClassNotFoundException | IOException e) {
            LOGGER.debug(e.getMessage());
            throw new SaveGameNotFoundException("Savegame file not found!");
        }
        return contextHolder;
    }
}
