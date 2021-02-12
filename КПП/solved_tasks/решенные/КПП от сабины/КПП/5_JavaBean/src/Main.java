import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
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
            System.out.println(dataSheet.getDate(0));
            dataSheet.setDate("2.3.4",0);
            System.out.println("Элементы: ");
            dataSheet.showAllDoc();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
