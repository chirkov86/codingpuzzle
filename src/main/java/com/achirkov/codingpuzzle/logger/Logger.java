package com.achirkov.codingpuzzle.logger;

public final class Logger {

    private static Logger instance;
    //TODO implement enabling via CLI command option
    //private boolean enabled = true;
    private boolean enabled;

    private Logger() {
        instance = this;
    }

    // Initialization on Demand Holder
    private static class Holder {
        private final static Logger instance = new Logger();
    }

    /**
     * @return Logger
     */
    public static Logger getInstance() {
        return Holder.instance;
    }

    public void debug(String s) {

        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StackTraceElement stackTraceElement = stackTrace[2];
        if (enabled && s!= null) {
            System.out.println("[DEBUG] " + stackTraceElement.getClassName() + stackTraceElement.getMethodName() + " " +
                    "- " + s);
        }
    }
}
