package fr.ndavid.tp2.format;

import fr.ndavid.tp2.LoggerBuilder;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public abstract class LogFormat {
    public abstract void format(LoggerBuilder message) throws ParserConfigurationException, IOException, SAXException, TransformerException;
}
