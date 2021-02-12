import org.w3c.dom.*;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;


import javax.xml.XMLConstants;
import javax.xml.parsers.*;
import javax.xml.transform.TransformerException;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
        dbf.setValidating(true);
        dbf.setIgnoringElementContentWhitespace(true);
        dbf.setIgnoringComments(true);

        Schema schema =null;
        SchemaFactory schemaFactory=SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
            schema=schemaFactory.newSchema(new File("data.xsd"));
        } catch (SAXException e) {
            e.printStackTrace();
        }
        dbf.setSchema(schema);

        MyErrorHandler myErrorHandler=new MyErrorHandler();
        try {
            DocumentBuilder db=dbf.newDocumentBuilder();
            db.setErrorHandler(myErrorHandler);
            Document document=db.parse(new File("data.xml"));

            DataSheet dataSheet=new DataSheet(document);
            dataSheet.showAllDoc();
//            NodeList nodeList=document.getElementsByTagName("x");
//            for(int i=0;i<nodeList.getLength();i++) {
//                System.out.println(nodeList.item(i).getTextContent());
//            dataSheet.setX(3,0);
//            System.out.println(dataSheet.getX(0));
            dataSheet.addData(dataSheet.createNEwElement("32.32.32",6,7));
//            DataSheet.print(document);
            System.out.println();
//            dataSheet.replaceDataEl(0,dataSheet.createNEwElement("3.3.3",11,11));
            try {
                dataSheet.saveDocument(new File("out.xml"));
            } catch (TransformerException e) {
                e.printStackTrace();
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
