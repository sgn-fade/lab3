import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Validator {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        String lang = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(lang);
        Schema schema = null;
        try {
            schema = factory.newSchema(new File("src/Popular_Baby_Names_NY.xsd"));
            javax.xml.validation.Validator validator = schema.newValidator();
            ErrorHandler handler = new SAXErrorCheckhandler();
            validator.setErrorHandler(handler);
            Source source = new StreamSource("src/Popular_Baby_Names_NY.xml");
            validator.validate(source);
            System.out.println("File valid");
        } catch (SAXException e) {
            System.out.println("File error");
        }
    }

    public static class SAXErrorCheckhandler extends DefaultHandler {
        @Override
        public void warning(SAXParseException e) throws SAXException {
            System.out.println("Warning: " + e.getMessage());
        }

        @Override
        public void error(SAXParseException e) throws SAXException {
            System.out.println("Error: " + e.getMessage());
        }

        @Override
        public void fatalError(SAXParseException e) throws SAXException {
            System.out.println("fatalError: " + e.getMessage());
        }
    }
}
