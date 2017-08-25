package com.nikita.kovalev;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Created by nikit on 31.07.2017.
 * Class parses the xml file using the DOM and displays it on the screen.
 */
public class Ex10 {

    public static void main(final String... args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        Document doc = null;

        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        try {
            File f = new File("Ex7");
            doc = builder.parse(f);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        readXML(doc);

    }

    public static void readXML(Document doc) {

        Element element = doc.getDocumentElement();
        NodeList nodeList = element.getChildNodes();

        for (int i = 0; i < nodeList.getLength(); i++) {
            System.out.print(element
                    .getElementsByTagName("cm").item(i)
                    .getTextContent() + "cm = ");
            System.out.print(element
                    .getElementsByTagName("mm").item(i)
                    .getTextContent() + "mm = ");
            System.out.println(element
                    .getElementsByTagName("px").item(i)
                    .getTextContent() + "px,");
        }
    }

}
