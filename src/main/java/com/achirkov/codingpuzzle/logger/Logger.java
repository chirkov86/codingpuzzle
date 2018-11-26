package com.achirkov.codingpuzzle.logger;

public final class Logger {

    private static Logger instance;
    //TODO implement enabling via CLI command option
    //private boolean enabled = true;
    private boolean enabled;

    private Logger() {
        instance = this;
    }

    /**
     * Not thread safe!
     * @return Logger
     */
    public static Logger getInstance() {
        if (instance == null) {
            return new Logger();
        } else return instance;
    }

    public void debug(String s) {

        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StackTraceElement stackTraceElement = stackTrace[2];
        if (enabled) {
            System.out.println("[DEBUG] " + stackTraceElement.getClassName() + stackTraceElement.getMethodName() + " - " + s);
        }
    }
}
