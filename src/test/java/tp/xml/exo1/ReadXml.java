package tp.xml.exo1;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.*;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;

/**
 * Created by youen on 16/03/2015.
 */
public class ReadXml {

    @Test
    public void should_read_xml_with_dom() throws ParserConfigurationException, IOException, SAXException {
        //Given
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(false);
        factory.setNamespaceAware(true);
        SchemaFactory schemaFactory =
                SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");

        factory.setSchema(schemaFactory.newSchema(
                new Source[] {new StreamSource(ReadXml.class.getResourceAsStream("/resume.xsd"))}));


        DocumentBuilder builder = factory.newDocumentBuilder();
        SimpleErrorHandler seh=new SimpleErrorHandler();

        builder.setErrorHandler(seh);
        //Then
        Document document = builder.parse(new InputSource(ReadXml.class.getResourceAsStream("/resume.xsd.xml")));
        NodeList nl=document.getElementsByTagName("firstname");

        //When
        assertFalse(seh.errorHappened);
        assertThat(nl.item(0).getTextContent()).isEqualTo("Julien");
    }

    @Test
    public void should_read_xml_with_sax() throws ParserConfigurationException, IOException, SAXException {
        //Given
        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setValidating(false);
        factory.setNamespaceAware(true);

        SchemaFactory schemaFactory =
                SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");

        factory.setSchema(schemaFactory.newSchema(
                new Source[] {new StreamSource(ReadXml.class.getResourceAsStream("/resume.xsd"))}));

        SAXParser parser = factory.newSAXParser();

        XMLReader reader = parser.getXMLReader();
        SimpleErrorHandler seh=new SimpleErrorHandler();
        reader.setErrorHandler(seh);

        SaxHandler sh=new SaxHandler();

        reader.setContentHandler(sh);

        //Then
        reader.parse(new InputSource(ReadXml.class.getResourceAsStream("/resume.xsd.xml")));

        //When
        assertFalse(seh.errorHappened);
        assertThat(sh.firstname).isEqualTo("Julien");

    }
}
