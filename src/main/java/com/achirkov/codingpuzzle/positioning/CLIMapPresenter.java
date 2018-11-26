package com.achirkov.codingpuzzle.positioning;

import javax.annotation.Nonnull;

import static com.achirkov.codingpuzzle.io.ColorCodes.*;

public class CliMapPresenter implements MapPresenter {

    @Override
    // TODO optimize: re-use pre-constructed StringBuilder
    public void printMap(@Nonnull GameMapManager gameMapManager) {
        StringBuilder sb = new StringBuilder();
        int dimension = gameMapManager.getDimension();

        for (int y = dimension - 1; y >= 0; y--) {
            for (int x = 0; x < dimension; x++) {
                if (gameMapManager.isPlayerPosition(x, y)) {
                    sb.append(BLUE_BOLD).append("P").append(ANSI_RESET).append(" ");
                } else if (gameMapManager.getEnemyAt(x, y).isPresent()
                        && gameMapManager.getEnemyAt(x, y).get().isAlive()
                        && gameMapManager.isPositionExplored(x, y)) {
                    sb.append(ANSI_RED).append("M").append(ANSI_RESET).append(" ");
                } else if (gameMapManager.isTreasurePosition(x, y)
                        && gameMapManager.isPositionExplored(x, y)) {
                    sb.append(ANSI_YELLOW).append("G").append(ANSI_RESET).append(" ");
                } else if (gameMapManager.isPositionExplored(x, y)) {
                    sb.append(WHITE_BACKGROUND).append("_").append(" ").append(ANSI_RESET);
                } else {
                    sb.append("_").append(" ").append(ANSI_RESET);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
