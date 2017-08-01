package com.nikita.kovalev;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by nikit on 31.07.2017.
 * Class parses the xml file using the StAX and displays it on the screen.
 */
public class Ex11 {

    public static void main(final String... args) {

        boolean iscm = false;
        boolean ismm = false;
        boolean ispx = false;

        XMLInputFactory factory = XMLInputFactory.newFactory();

        try {
            XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream("Ex7"));
            while (reader.hasNext()) {
                int res = reader.next();
                if (res == reader.START_ELEMENT) {
                    if (reader.getLocalName().equals("cm")) {
                        iscm = true;
                    } else if (reader.getLocalName().equals("mm")) {
                        ismm = true;
                    } else if (reader.getLocalName().equals("px")) {
                        ispx = true;
                    }
                } else if (res == reader.CHARACTERS) {
                    if (iscm) {
                        System.out.print(reader.getText() + "cm = ");
                        iscm = false;
                    } else if (ismm) {
                        System.out.print(reader.getText() + "mm = ");
                        ismm = false;
                    } else if (ispx) {
                        System.out.println(reader.getText() + "px,");
                        ispx = false;
                    }
                }
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
    }
}
