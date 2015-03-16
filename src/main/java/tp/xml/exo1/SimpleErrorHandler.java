package tp.xml.exo1;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 * Created by youen on 16/03/2015.
 */
public class SimpleErrorHandler implements ErrorHandler {

    public boolean errorHappened =false;

    public void warning(SAXParseException e) throws SAXException {
        System.out.println(e.getMessage());
        errorHappened =true;
    }

    public void error(SAXParseException e) throws SAXException {
        System.out.println(e.getMessage());
        errorHappened =true;
    }

    public void fatalError(SAXParseException e) throws SAXException {
        System.out.println(e.getMessage());
        errorHappened =true;
    }
}
