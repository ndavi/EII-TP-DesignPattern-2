package fr.ndavid.tp2.state;

import fr.ndavid.tp2.LogType;
import fr.ndavid.tp2.LoggerBuilder;
import fr.ndavid.tp2.format.LogFormat;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public class LoggerErrorState extends LoggerState {

    public LoggerErrorState(LogFormat format) {
        super.type = LogType.ERROR;
        this.format = format;
    }

    @Override
    public void log(LoggerBuilder builder) throws ParserConfigurationException, TransformerException, SAXException, IOException {
        if(builder.type == super.type) {
            format.format(builder);
        }
    }
}

