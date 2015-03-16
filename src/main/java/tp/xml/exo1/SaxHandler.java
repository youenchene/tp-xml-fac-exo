package tp.xml.exo1;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by youen on 16/03/2015.
 */
public class SaxHandler extends DefaultHandler {

    boolean bfname = false;
    public String firstname = null;

    public void startElement(String uri, String localName,String qName,
                             Attributes attributes) throws SAXException {

        System.out.println("Start Element :" + qName);

        if (qName.equalsIgnoreCase("FIRSTNAME")) {
            bfname = true;
        }

    }

    public void endElement(String uri, String localName,
                           String qName) throws SAXException {

        System.out.println("End Element :" + qName);

    }

    public void characters(char ch[], int start, int length) throws SAXException {

        if (bfname) {
            System.out.println("First Name : " + new String(ch, start, length));
            firstname=new String(ch, start, length);
            bfname = false;
        }


    }

}


