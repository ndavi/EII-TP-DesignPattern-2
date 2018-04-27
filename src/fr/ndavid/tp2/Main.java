package fr.ndavid.tp2;


import fr.ndavid.tp2.format.LogRawFormat;
import fr.ndavid.tp2.format.LogXMLFormat;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

class Message extends Thread {
    private Logger logger;
    public void run() {
        try {
            logger.log(new LoggerBuilder().withMessage("Application exiting"));
        } catch (ParserConfigurationException | IOException | SAXException | TransformerException e) {
            e.printStackTrace();
        }
    }

    Message(Logger logger) {
        this.logger = logger;
    }
}

public class Main {

    static Logger debugLogger;
    static Logger infoLogger;
    static Logger errorLogger;

    public static void main(String[] args) throws TransformerException, ParserConfigurationException {
        debugLogger = Logger.getInstance(LogType.DEBUG, new LogXMLFormat());
        infoLogger = Logger.getInstance(LogType.INFO, new LogRawFormat());
        errorLogger = Logger.getInstance(LogType.ERROR, new LogRawFormat());

        Runtime.getRuntime().addShutdownHook(new Message(infoLogger));
        try {
            testLogDebug();
            testLogInfo();
            testLogError();
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    static void testLogDebug() throws ParserConfigurationException, TransformerException, SAXException, IOException {
        debugLogger.log(new LoggerBuilder().withMessage("MESSAGE DEBUG DANS LOGGER DEBUG").withState(LogType.DEBUG));
        debugLogger.log(new LoggerBuilder().withMessage("MESSAGE INFO DANS LOGGER DEBUG").withState(LogType.INFO));
        debugLogger.log(new LoggerBuilder().withMessage("MESSAGE ERROR DANS LOGGER DEBUG").withState(LogType.ERROR));

    }

    static void testLogInfo() throws ParserConfigurationException, TransformerException, SAXException, IOException {
        infoLogger.log(new LoggerBuilder().withClass("MAIN CLASS").withMessage("MESSAGE INFO DANS LOGGER INFO").withState(LogType.INFO));
        infoLogger.log(new LoggerBuilder().withClass("MAIN CLASS").withMessage("MESSAGE ERROR DANS LOGGER INFO").withState(LogType.ERROR));
        infoLogger.log(new LoggerBuilder().withClass("MAIN CLASS").withMessage("MESSAGE DEBUG DANS LOGGER INFO").withState(LogType.DEBUG));

    }

    static void testLogError() throws ParserConfigurationException, TransformerException, SAXException, IOException {
        errorLogger.log(new LoggerBuilder().withClass("MAIN CLASS").withMessage("MESSAGE ERROR DANS LOGGER ERROR").withState(LogType.ERROR));
        errorLogger.log(new LoggerBuilder().withClass("MAIN CLASS").withMessage("MESSAGE INFO DANS LOGGER ERROR").withState(LogType.INFO));
        errorLogger.log(new LoggerBuilder().withClass("MAIN CLASS").withMessage("MESSAGE DEBUG DANS LOGGER ERROR").withState(LogType.DEBUG));

    }
}
