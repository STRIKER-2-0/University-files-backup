package functional;

import com.sun.org.apache.xml.internal.utils.DefaultErrorHandler;
import functional.interfaces.DataBaseChangeListener;
import functional.interfaces.ServerRegistry;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.*;
import java.rmi.RemoteException;

public class Server implements ServerRegistry {
    private DataBase dataBase;

    public Server(){
        dataBase=new DataBase();
    }

    public synchronized void register(Participant participant) throws RemoteException {
        dataBase.add(participant);
    }

    public synchronized int size() {
        return dataBase.size();
    }

    @Override
    public synchronized String getInfo() throws RemoteException {
        TransformerFactory transformerFactory=TransformerFactory.newInstance();
        Transformer transformer= null;
        try {
            transformer = transformerFactory.newTransformer();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }
        transformer.setOutputProperty(OutputKeys.INDENT,"yes");
        transformer.setOutputProperty(OutputKeys.ENCODING,"UTF-8");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount","4");
        DOMSource xmlSource= null;
        try {
            xmlSource = new DOMSource(dataBase.convertToDocument());
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        StringWriter writer=new StringWriter();
        StreamResult result=new StreamResult(writer);
        try {
            transformer.transform(xmlSource,result);
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        writer.flush();
        return writer.toString();
    }

    public DataBase getDataBase() {
        return dataBase;
    }

    public void saveDoc(File file) throws FileNotFoundException, TransformerException, ParserConfigurationException {
        TransformerFactory transformerFactory=TransformerFactory.newInstance();
        Transformer transformer=transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT,"yes");
        transformer.setOutputProperty(OutputKeys.ENCODING,"windows-1251");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount","4");
        DOMSource xmlSource=new DOMSource(dataBase.convertToDocument());
        StreamResult result=new StreamResult(new FileOutputStream(file));
        transformer.transform(xmlSource,result);
    }

    public void fillDoc(File filexml,File filexsd){
        DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
        dbf.setValidating(true);
        dbf.setIgnoringElementContentWhitespace(true);
        dbf.setIgnoringComments(true);

        Schema schema =null;
        SchemaFactory schemaFactory=SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
            schema=schemaFactory.newSchema(filexsd);
        } catch (SAXException e) {
            e.printStackTrace();
        }
        dbf.setSchema(schema);

        try {
            DocumentBuilder db=dbf.newDocumentBuilder();
            db.setErrorHandler(new MyErrorHandler());
            Document document=db.parse(filexml);

            //заполняем DataBase
            dataBase.clear();
            NodeList nodeList=document.getDocumentElement().getElementsByTagName("Participant");
//            System.out.println(nodeList.item(0).getChildNodes().item(0).getChildNodes().item(0).getTextContent());
//            System.out.println(nodeList.getLength());
            for(int i=0;i<nodeList.getLength();i++){
                Node n=nodeList.item(i);
                dataBase.add(new Participant(n.getChildNodes().item(0).getChildNodes().item(0).getTextContent(),
                                             n.getChildNodes().item(1).getChildNodes().item(0).getTextContent(),
                                             n.getChildNodes().item(2).getChildNodes().item(0).getTextContent(),
                                             n.getChildNodes().item(3).getChildNodes().item(0).getTextContent(),
                                             n.getChildNodes().item(4).getChildNodes().item(0).getTextContent()));
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
