package xml;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;
import org.xml.sax.SAXException;


public class XmlDOMParser {
	public static Document docum;
	
	public static Document getParse(String s){
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		File xmlFile = new File(s);
		dbf.setValidating(true);
		Document doc = null;
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			doc = db.parse(xmlFile);
		} catch (ParserConfigurationException e) { e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return doc;
	}
	
	public static Document createDoc() {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setValidating(true);
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			docum = db.newDocument();
		} catch (ParserConfigurationException e) { e.printStackTrace();
		}
		return docum;

	}
	
	public static void CastToXML(String fileName, Document doc) throws TransformerException, 
	FileNotFoundException {
		TransformerFactory transFactory = TransformerFactory.newInstance();
		Transformer transformer = transFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		File newXMLFile = new File(fileName);
		FileOutputStream fos = new FileOutputStream(newXMLFile);
		StreamResult result = new StreamResult(fos);
		transformer.transform(source, result);
	}
	
	private static void stepThrough(Node start) {
		System.out.println(start.getNodeName() + " = " + start.getNodeValue());
		if (start instanceof Element) {
			NamedNodeMap startAttr = start.getAttributes();
			for (int i = 0; i < startAttr.getLength(); i++) {
				Node attr = startAttr.item(i);
				System.out.println(" Attribute: " + attr.getNodeName() + " = "
						+ attr.getNodeValue());
			}
		}
		for (Node child = start.getFirstChild(); child != null;
				child = child.getNextSibling()) {
			stepThrough(child);
		}
	}
	
	public static void processDocument(Document doc) {
		Element rootEl = doc.getDocumentElement();
		System.out.println("Root element: " + rootEl.getNodeName());
		System.out.println("Child elements: ");
		stepThrough(rootEl);
		}
	
	public static void getSelectInfa(Document doc) {
		NodeList nl1 = doc.getDocumentElement().getElementsByTagName("x");
		NodeList nl2 = doc.getDocumentElement().getElementsByTagName("y");
		if (nl1.getLength() == nl2.getLength()) {
			for (int i = 0; i < nl1.getLength(); i++) {
				System.out.println(nl1.item(i).getNodeName() + " "
						+ nl1.item(i).getTextContent() + "\t"
						+ nl2.item(i).getNodeName() + " "
						+ nl2.item(i).getTextContent());
			}
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException, TransformerException{
		Document doc = getParse("MyXML.xml");
		DOMDataSheet dsh = new DOMDataSheet(doc);
		dsh.addElement(dsh.newElement("19.04.2018", 19, 4));
		CastToXML("NewXML.xml",dsh.getDoc());
	}
}
