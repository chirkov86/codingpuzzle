package com.achirkov.codingpuzzle.logger;

public class Logger {

    private static Logger instance = null;
//    private boolean enabled = true;
    private boolean enabled;

    private Logger() {
    }

    /**
     * Factory method
     *
     * @return Logger
     */
    public static Logger getInstance() {
        if (instance == null) {
            return new Logger();
        } else return instance;
    }

    public void debug(String s) {

        if (enabled) {
            System.out.println("[DEBUG]: " + s);
        }
    }
}
