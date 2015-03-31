package tp.xml.exo1;

import org.junit.Test;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import java.io.IOException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by youen on 17/03/2015.
 */
public class Validate2Xml {

    @Test
    public void should_validate_with_DOM() throws ParserConfigurationException, SAXException, IOException {
        //Given
        DocumentBuilderFactory factory= DocumentBuilderFactory.newInstance();
        factory.setValidating(false);
        factory.setNamespaceAware(true);
        SchemaFactory schemaFactory =
                SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");

        factory.setSchema(schemaFactory.newSchema(
                new Source[] {new StreamSource(ValidateXml.class.getResourceAsStream("/resume.xsd"))}));


        DocumentBuilder builder = factory.newDocumentBuilder();
        SimpleErrorHandler seh=new SimpleErrorHandler();

        builder.setErrorHandler(seh);
        //When
        builder.parse(new InputSource(Validate2Xml.class.getResourceAsStream("/resume.xsd.xml")));
        //Then
        assertFalse(seh.errorHappened);
    }

    @Test
    public void should_not_validate_with_DOM() throws ParserConfigurationException, SAXException, IOException {
        //Given
        DocumentBuilderFactory factory= DocumentBuilderFactory.newInstance();
        factory.setValidating(false);
        factory.setNamespaceAware(true);
        SchemaFactory schemaFactory =
                SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");

        factory.setSchema(schemaFactory.newSchema(
                new Source[] {new StreamSource(ValidateXml.class.getResourceAsStream("/resume.xsd"))}));


        DocumentBuilder builder = factory.newDocumentBuilder();
        SimpleErrorHandler seh=new SimpleErrorHandler();

        builder.setErrorHandler(seh);
        //When
        builder.parse(new InputSource(Validate2Xml.class.getResourceAsStream("/resume3.xsd.xml")));
        //Then
        assertTrue(seh.errorHappened);
    }
}
