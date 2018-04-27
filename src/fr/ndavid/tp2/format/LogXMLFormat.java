package fr.ndavid.tp2.format;

import fr.ndavid.tp2.LoggerBuilder;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;

public class LogXMLFormat extends LogFormat {

    public LogXMLFormat() throws ParserConfigurationException, TransformerException {
        java.io.File f = new  java.io.File("log.xml");
        if(!f.exists() && !f.isDirectory()) {

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // root elements
            Document doc = docBuilder.newDocument();
            Element log = doc.createElement("log");
            doc.appendChild(log);

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new java.io.File("log.xml"));

            // Output to console for testing
            // StreamResult result = new StreamResult(System.out);

            transformer.transform(source, result);

            System.out.println("Log file created!");
        }
    }

    @Override
    public void format(LoggerBuilder builder) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse("log.xml");
        Element root = document.getDocumentElement();
        Element record = document.createElement("record");
        record.setAttribute("method", builder.method);
        record.setAttribute("class", builder.classe);
        record.setAttribute("level", builder.type.toString());
        record.setAttribute("message", builder.message);

        root.appendChild(record);

        DOMSource source = new DOMSource(document);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        StreamResult result = new StreamResult("log.xml");
        transformer.transform(source, result);

    }
}
