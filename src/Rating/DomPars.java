package Rating;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public abstract class  DomPars {

    public static void WriteDocument(String filepath, ArrayList<BabiesList> babiesLists) throws ParserConfigurationException, TransformerConfigurationException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = docFactory.newDocumentBuilder();
        Document doc = builder.newDocument();
        DomResponse DomRes = new DomResponse(doc);
        DomRes.addRootElement("list");
        for (BabiesList list : babiesLists){
            DomRes.addElement(list);
        }

        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer();
        transformer.setOutputProperty(OutputKeys.ENCODING, "Windows-1251");
        transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

        DOMSource source = new DOMSource(DomRes.getDocument());
        StreamResult result = new StreamResult(new File(filepath.trim()));
        try {
            transformer.transform(source, result);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }
        try {
            ReadDocument(filepath, DomRes.getDocument());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void ReadDocument(String filepath, Document document) throws IOException {
        int num = document.getDocumentElement().getElementsByTagName("ethocity_group").getLength();

        NodeList lstName = document.getDocumentElement().getElementsByTagName("ethocity_group");

        for (int i = 0; i < num; i++) {
            System.out.println("Ethocity: ");
            NamedNodeMap attrs = lstName.item(i).getAttributes();

            System.out.println("\t" + attrs.item(i).getNodeName() + ": " + attrs.item(i).getNodeValue().trim());
            int babiesNum = lstName.item(i).getChildNodes().getLength();
            NodeList babies = lstName.item(i).getChildNodes();

            for(int j = 0; j < babiesNum; j++) {
                attrs = babies.item(j).getAttributes();
                for(int k = 0; k < attrs.getLength(); k++) {
                    Node attr = attrs.item(k);
                    System.out.print("\t" + attr.getNodeName() + ": " + attr.getNodeValue().trim());
                }
                System.out.println();
            }
        }
    }
}
