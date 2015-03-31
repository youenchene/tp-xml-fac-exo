package tp.xml.exo2;

import org.junit.Test;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * Created by youen on 31/03/2015.
 */
public class XSLTTest {


    @Test
    public void should_tranform_to_html() throws TransformerException {
        TransformerFactory tFactory = TransformerFactory.newInstance();
        Transformer transformer = tFactory.newTransformer(new StreamSource(XSLTTest.class.getResourceAsStream("/tohtml.xsl")));

        transformer.transform(new StreamSource(XSLTTest.class.getResourceAsStream("/resume.xsd.xml")), new StreamResult("resume.htm"));
    }
}
