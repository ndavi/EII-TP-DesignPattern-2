package fr.ndavid.tp2.state;

import fr.ndavid.tp2.LogType;
import fr.ndavid.tp2.LoggerBuilder;
import fr.ndavid.tp2.format.LogFormat;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;


//Pas très utile non plus car duplication de classe inutile, il vaut mieux avoir un tableau de type de logger plutot que plusieurs classes de logger

public abstract class LoggerState {
    public LogType type;
    public abstract void log(LoggerBuilder message) throws ParserConfigurationException, TransformerException, SAXException, IOException;
    public LogFormat format;
}