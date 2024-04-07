package Rating;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class DomResponse {
    private final Document document;

    public DomResponse(Document document) {
        this.document = document;
    }

    public Document getDocument() {
        return document;
    }

    public int getRowCount() {
        return document.getDocumentElement().getElementsByTagName("row").getLength();
    }

    public String getName(int pos) {
        return document.getDocumentElement().getElementsByTagName("nm").item(pos).getTextContent().trim();
    }

    public String getGender(int pos) {
        return document.getDocumentElement().getElementsByTagName("gndr").item(pos).getTextContent().trim();
    }

    public String getBirthday(int pos) {
        return document.getDocumentElement().getElementsByTagName("brth_yr").item(pos).getTextContent().trim();
    }

    public String getEthcty(int pos) {
        return document.getDocumentElement().getElementsByTagName("ethcty").item(pos).getTextContent().trim();
    }

    public String getCount(int pos) {
        return document.getDocumentElement().getElementsByTagName("cnt").item(pos).getTextContent().trim();
    }

    public String getRank(int pos) {
        return document.getDocumentElement().getElementsByTagName("rnk").item(pos).getTextContent().trim();
    }
    public void addElement(BabiesList babies){
        Element EthnocityGroup = document.createElement("ethocity group");
        for(Baby baby : babies.getBabies()){
            Element babyEl = document.createElement("baby");
            Attr attr = document.createAttribute("name");
            attr.setValue(baby.getName());
            babyEl.setAttributeNode(attr);
            attr = document.createAttribute("birthday");
            attr.setValue(baby.getBirthDate());
            babyEl.setAttributeNode(attr);
            attr = document.createAttribute("gender");
            attr.setValue(baby.getGender());
            babyEl.setAttributeNode(attr);
            attr = document.createAttribute("count");
            attr.setValue(baby.getCount());
            babyEl.setAttributeNode(attr);
            attr = document.createAttribute("rank");
            attr.setValue(baby.getRnk());
            babyEl.setAttributeNode(attr);
            EthnocityGroup.appendChild(babyEl);
        }
        document.getDocumentElement().appendChild(EthnocityGroup);
    }
}
