import java.io.IOException;
import java.util.logging.*;

public class JULogger {

    public Logger myLogger;
    private final Level LEVEL = Level.ALL;
    private final String pattern = "./log/JULogger.%g.log";

    public JULogger (String className) {

        myLogger = Logger.getLogger(className);

        Handler consoleHandler;
        Handler fileHandler;
        Formatter simpleFormatter;

        try {
            simpleFormatter = new SimpleFormatter();
            consoleHandler = new ConsoleHandler();
            fileHandler = new FileHandler(pattern, 20000, 5, true);

            consoleHandler.setFormatter(simpleFormatter);
            fileHandler.setFormatter(simpleFormatter);

            myLogger.addHandler(consoleHandler);
            myLogger.addHandler(fileHandler);

            consoleHandler.setLevel(LEVEL);
            fileHandler.setLevel(LEVEL);
            myLogger.setLevel(LEVEL);

            myLogger.config("Configuration done.\n");

            myLogger.removeHandler(consoleHandler);

            myLogger.log(Level.FINE, "Finer logged\n");
        } catch (IOException ioe) {
            myLogger.log(Level.SEVERE, "Error occur in FileHandler.\n", ioe);
        }

        myLogger.finer("Finest example on LOGGER handler completed.\n");
    }
}