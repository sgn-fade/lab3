import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ethctyCheck {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        ethctyHandler handler = new ethctyHandler();
        parser.parse(new File("src/Popular_Baby_Names_NY.xml"), handler);

    }
    public static class ethctyHandler extends DefaultHandler {
        private static ArrayList<String> ethcty = new ArrayList<String>();

        private boolean inEthcty = false;

        @Override
        public void startDocument() throws SAXException {
            super.startDocument();
        }


        @Override
        public void endDocument() throws SAXException {
            System.out.println(ethcty);
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if(qName.equals("ethcty")){
                inEthcty = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            super.endElement(uri, localName, qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if(inEthcty){
                String str = new String(ch, start, length);
                if(!ethcty.contains(str)){
                    ethcty.add(str);
                }
                inEthcty = false;
            }
        }
    }
}
