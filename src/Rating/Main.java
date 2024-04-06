package Rating;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


// <brth_yr>2012</brth_yr>
// <gndr>FEMALE</gndr>
// <ethcty>WHITE NON HISP</ethcty>
// <nm>GIANNA</nm>
// <cnt>48</cnt>
// <rnk>45</rnk>
//end
public class Main {
    private static final ArrayList<BabiesList> EthnicityBabyList = new ArrayList<>();
    private static boolean inRow = false;
    private static String currentElement;
    private static String brth_yr, gndr, ethcty, nm, cnt, rnk;

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        Handler handler = new Handler();
        parser.parse(new File("src/Popular_Baby_Names_NY.xml"), handler);

    }
    public static class Handler extends DefaultHandler {
        @Override
        public void startDocument() throws SAXException {
            super.startDocument();
        }

        @Override
        public void endDocument() throws SAXException {
            for(BabiesList list : EthnicityBabyList){
                System.out.println(list.toString());
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if(qName.equals("row")) {
                boolean newList = true;
                Baby baby = new Baby(nm, brth_yr, gndr, ethcty, cnt, rnk);
                for(BabiesList list : EthnicityBabyList){
                    if(list.getEthnicity().equals(ethcty)){
                        list.add(baby);
                        newList = false;
                        break;
                    }
                }
                if(newList){
                    BabiesList babies = new BabiesList(ethcty);
                    babies.add(baby);
                    EthnicityBabyList.add(babies);
                }
                inRow = false;
            }

            currentElement = "";

        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if(qName.equals("row")){
                inRow = true;
            }
            currentElement = qName;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (inRow) {
                String value = new String(ch, start, length);
                switch (currentElement) {
                    case "brth_yr":
                        brth_yr = value;
                        break;
                    case "gndr":
                        gndr = value;
                        break;
                    case "ethcty":
                        ethcty = value;
                        break;
                    case "nm":
                        nm = value;
                        break;
                    case "cnt":
                        cnt = value;
                        break;
                    case "rnk":
                        rnk = value;
                        break;
                }
            }
        }
    }
}

