package fr.ndavid.tp2.format;

import fr.ndavid.tp2.LoggerBuilder;

public class LogRawFormat extends LogFormat {

    @Override
    public void format(LoggerBuilder builder) {
        String message = builder.classe + " " + builder.method + " : " + builder.message;
        System.out.println("INFO: " + message);
    }
}
