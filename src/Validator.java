import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Validator {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setValidating(true);

        try {
            SAXParser parser = factory.newSAXParser();
            DefaultHandler handler = new SAXErrorCheckhandler();
            InputStream xmlStream = new FileInputStream("src/Popular_Baby_Names_NY.xml");
            parser.parse(xmlStream, handler);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }finally {
            System.out.println("No Error");
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
