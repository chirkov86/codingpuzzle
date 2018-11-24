package com.achirkov.codingpuzzle.io;

public interface ColorCodes {
    String ANSI_RESET = "\u001B[0m";

    // Regular Colors
    String ANSI_BLACK = "\u001B[30m";
    String ANSI_RED = "\u001B[31m";
    String ANSI_GREEN = "\u001B[32m";
    String ANSI_YELLOW = "\u001B[33m";
    String ANSI_BLUE = "\u001B[34m";
    String ANSI_PURPLE = "\u001B[35m";
    String ANSI_CYAN = "\u001B[36m";
    String ANSI_WHITE = "\u001B[37m";

    // Background
    String BLACK_BACKGROUND = "\033[40m";  // BLACK
    String RED_BACKGROUND = "\033[41m";    // RED
    String GREEN_BACKGROUND = "\033[42m";  // GREEN
    String YELLOW_BACKGROUND = "\033[43m"; // YELLOW
    String BLUE_BACKGROUND = "\033[44m";   // BLUE
    String PURPLE_BACKGROUND = "\033[45m"; // PURPLE
    String CYAN_BACKGROUND = "\033[46m";   // CYAN
    String WHITE_BACKGROUND = "\033[47m";  // WHITE


    // Bold
    String BLACK_BOLD = "\033[1;30m";  // BLACK
    String RED_BOLD = "\033[1;31m";    // RED
    String GREEN_BOLD = "\033[1;32m";  // GREEN
    String YELLOW_BOLD = "\033[1;33m"; // YELLOW
    String BLUE_BOLD = "\033[1;34m";   // BLUE
    String PURPLE_BOLD = "\033[1;35m"; // PURPLE
    String CYAN_BOLD = "\033[1;36m";   // CYAN
    String WHITE_BOLD = "\033[1;37m";  // WHITE
}
