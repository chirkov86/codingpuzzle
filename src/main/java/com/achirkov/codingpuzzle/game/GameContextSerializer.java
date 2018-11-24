package com.achirkov.codingpuzzle.game;

import com.achirkov.codingpuzzle.logger.Logger;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class GameContextSerializer {
    private final static Logger LOGGER = Logger.getInstance();
    private ObjectMapper objectMapper;

    public GameContextSerializer() {
        this.objectMapper = new ObjectMapper();
    }

    public void serializeContext(GameContextHolder gameContextHolder) throws IOException {
        File dir = new File("savegames");
        if (!dir.exists()) {
            dir.mkdir();
        }
        objectMapper.writeValue(new File("savegames/savegame.json"), gameContextHolder);
    }
}
