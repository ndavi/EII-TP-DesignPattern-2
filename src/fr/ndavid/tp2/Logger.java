package fr.ndavid.tp2;

import fr.ndavid.tp2.format.LogFormat;
import fr.ndavid.tp2.format.LogRawFormat;
import fr.ndavid.tp2.state.LoggerDebugState;
import fr.ndavid.tp2.state.LoggerErrorState;
import fr.ndavid.tp2.state.LoggerInfoState;
import fr.ndavid.tp2.state.LoggerState;
import fr.ndavid.tp2.utils.ClassFinder;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.EnumMap;
import java.util.Optional;

public class Logger {

    private static EnumMap<LogType, Logger> loggers = new EnumMap<>(LogType.class);

    private LoggerState state;


    static Logger getInstance(LogType type, LogFormat format) {
        return Optional.ofNullable(loggers.get(type)).orElseGet(() -> {
            loggers.put(type, new Logger(type, format));
            return loggers.get(type);
        });
    }

    static Logger getInstance(LogType type) {
        return Optional.ofNullable(loggers.get(type)).orElseGet(() -> {
            loggers.put(type, new Logger(type, new LogRawFormat()));
            return loggers.get(type);
        });
    }

    private Logger(LogType type, LogFormat format) {
        switch (type) {
            case ERROR:
                this.state = new LoggerErrorState(format);
                break;
            case DEBUG:
                this.state = new LoggerDebugState(format);
                break;
            case INFO:
                this.state = new LoggerInfoState(format);
                break;
        }
    }

    public void log(LoggerBuilder builder) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        if(builder.classe == null || builder.classe.isEmpty()) {
            builder.classe = ClassFinder.getCallerClassName();
        }
        if(builder.method == null || builder.method.isEmpty()) {
            builder.method = ClassFinder.getCallerMethodName();
        }
        this.state.log(builder);
    }

    /* Inutile car l'info est envoyée en paramètre de méthode
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
    }*/

}
