import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

//row _id="row-r89z_28kf.f2dg"
// _uuid="00000000-0000-0000-35D3-7F7752435B2D"
// _position="0"
// _address="https://data.cityofnewyork.us/resource/_25th-nujf/row-r89z_28kf.f2dg">
// <brth_yr>2012</brth_yr>
// <gndr>FEMALE</gndr>
// <ethcty>WHITE NON HISP</ethcty>
// <nm>GIANNA</nm>
// <cnt>48</cnt>
// <rnk>45</rnk>
//end
public class SAXPar {
    private static ArrayList<String> tags = new ArrayList<String>();
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        Handler handler = new Handler();
        parser.parse(new File("src/Popular_Baby_Names_NY.xml"), handler);

    }
    public static class Handler extends DefaultHandler {
        private int count = 10;
        private boolean inRow = false;
        private String currentElement;
        private String brth_yr, gndr, ethcty, nm, cnt, rnk;
        private void dec(){
            count--;
        }
        @Override
        public void startDocument() throws SAXException {
            super.startDocument();
        }


        @Override
        public void endDocument() throws SAXException {
            System.out.println("tags: " + tags);
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if(count == 0){
                System.out.println("tags: " + tags);
                System.exit(0);

            }
            if(!tags.contains(qName)){
                tags.add(qName);
            }
            if(qName.equals("row")){
                inRow = true;

                dec();
            }
            currentElement = qName;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("row")) {
                inRow = false;
                System.out.println("Birth Year: " + brth_yr);
                System.out.println("Gender: " + gndr);
                System.out.println("Ethnicity: " + ethcty);
                System.out.println("Name: " + nm);
                System.out.println("Count: " + cnt);
                System.out.println("Rank: " + rnk);
                System.out.println("---------------------");
            }
            currentElement = "";
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
