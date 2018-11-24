package com.achirkov.codingpuzzle.positioning;

import static com.achirkov.codingpuzzle.io.ColorCodes.*;

public class CLIMapPresenter implements MapPresenter {

    @Override
    public void printMap(GameMap gameMap) {
        StringBuilder sb = new StringBuilder();
        int dimension = gameMap.getDimension();

        for (int y = dimension - 1; y >= 0; y--) {
            for (int x = 0; x < dimension; x++) {
                if (gameMap.isPlayerPosition(x, y)) {
                    sb.append(ANSI_BLUE).append("P").append(ANSI_RESET).append(" ");
                } else if (gameMap.isMonsterPosition(x, y) && gameMap.getEnemyAt(x, y).get().isAlive()) {
                    sb.append(ANSI_RED).append("M").append(ANSI_RESET).append(" ");
                } else {
                    sb.append("_").append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
