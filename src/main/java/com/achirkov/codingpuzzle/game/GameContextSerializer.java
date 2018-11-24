package com.achirkov.codingpuzzle.game;

import com.achirkov.codingpuzzle.exceptions.SaveGameNotFoundException;
import com.achirkov.codingpuzzle.logger.Logger;

import java.io.*;

public class GameContextSerializer {
    private static final Logger LOGGER = Logger.getInstance();

    public void serializeContext(GameContextHolder gameContextHolder) {
        File dir = new File("savegames");
        if (!dir.exists()) {
            dir.mkdir();
        }
        try (FileOutputStream fos = new FileOutputStream(new File("savegames/savegame.json"));
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(gameContextHolder);
        } catch (IOException e) {
            LOGGER.debug(e.getMessage());
        }
    }

    public GameContextHolder deserializeContext() throws ClassNotFoundException {
        File file = new File("savegames/savegame.json");
        GameContextHolder value = null;

        if (!file.exists()) {
            throw new SaveGameNotFoundException("");
        }
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            value = (GameContextHolder) ois.readObject();
        } catch (IOException e) {
            LOGGER.debug(e.getMessage());
        }
        return value;
    }
}
