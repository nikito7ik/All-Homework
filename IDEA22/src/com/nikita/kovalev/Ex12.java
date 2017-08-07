package com.nikita.kovalev;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.IOException;

/**
 * Created by nikit on 02.08.2017.
 * This class converts xml file to html
 */
public class Ex12 {

    public static Document doc = null;

    public static void main(final String... args) {
        Document_Ex();
        File stylesheet = new File("Ex12.xsl");
        StreamSource styleSource = new StreamSource(stylesheet);

        try {
            Transformer t = TransformerFactory.newInstance().newTransformer(styleSource);
            t.getOutputProperties();
            t.transform(new DOMSource(doc.getDocumentElement()), new StreamResult(System.out));
        } catch (TransformerException e) {
            e.printStackTrace();
        }

    }
    
    public static void Document_Ex() {
        File f = new File("Ex7");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            doc = builder.parse(f);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

    }

}
