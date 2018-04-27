/*package fr.ndavid.tp2.doubleDispatch;

import fr.ndavid.tp2.LogType;
import fr.ndavid.tp2.LoggerBuilder;
import fr.ndavid.tp2.state.LoggerDebugState;
import fr.ndavid.tp2.state.LoggerErrorState;
import fr.ndavid.tp2.state.LoggerInfoState;
import fr.ndavid.tp2.state.LoggerState;

import java.util.EnumMap;
import java.util.Optional;

public class Logger {

    private static EnumMap<LogType, Logger> loggers = new EnumMap<>(LogType.class);

    private LoggerState state;


    protected static Logger getInstance(LogType type) {
        return Optional.ofNullable(loggers.get(type)).orElseGet(() -> {
            loggers.put(type, new Logger(type));
            return loggers.get(type);
        });
    }

    protected Logger(LogType type) {
        switch (type) {
            case ERROR:
                this.state = new LoggerErrorState();
                break;
            case DEBUG:
                this.state = new LoggerDebugState();
                break;
            case INFO:
                this.state = new LoggerInfoState();
                break;
        }
    }

    public void log(LoggerBuilder builder) {
        this.state.log(builder);
    }

     Inutile car l'info est envoyée en paramètre de méthode
    public void logInfo(String message) {
        if(type == LogType.INFO) {
            System.out.println(message);
        }
    }

    public void logError(String message) {
        if(type == LogType.ERROR) {
            System.out.println(message);
        }
    }

    public void logDebug(String message) {
        if(type == LogType.DEBUG) {
            System.out.println(message);
        }
    }

}
        */