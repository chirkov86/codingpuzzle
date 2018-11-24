package com.achirkov.codingpuzzle.positioning;

import static com.achirkov.codingpuzzle.io.ColorCodes.*;

public class CLIMapPresenter implements MapPresenter {

    @Override
    public void printMap(GameMapManager gameMapManager) {
        StringBuilder sb = new StringBuilder();
        int dimension = gameMapManager.getDimension();

        for (int y = dimension - 1; y >= 0; y--) {
            for (int x = 0; x < dimension; x++) {
                if (gameMapManager.isPlayerPosition(x, y)) {
                    sb.append(ANSI_BLUE).append("P").append(ANSI_RESET).append(" ");
                } else if (gameMapManager.isMonsterPosition(x, y) && gameMapManager.getEnemyAt(x, y).get().isAlive()) {
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
