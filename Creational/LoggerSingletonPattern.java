// LoggerSingletonPattern.java
class Logger {
    private static Logger instance;
    private int logCount = 0;

    private Logger() { }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        logCount++;
        System.out.println("Log " + logCount + ": " + message);
    }
}

public class LoggerSingletonPattern {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        logger1.log("First log");

        Logger logger2 = Logger.getInstance();
        logger2.log("Second log");

        System.out.println("Both logger1 and logger2 are the same instance: " + (logger1 == logger2));
    }
}

