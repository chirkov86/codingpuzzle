package com.achirkov.codingpuzzle.io;

public final class IOUtils {

    private IOUtils() {
    }

    public static String padLeft(String s, int n) {
        return String.format("%1$" + n + "s", s);
    }

}
