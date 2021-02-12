import java.io.FileNotFoundException;
import java.util.Iterator;

import javax.xml.transform.TransformerException;

public class DataSheetToXML {
	private static XMLSAXParser parser;
	private static XmlDOMParser DomParser;
	private static DOMDataSheet DOMdataSheet;
	
	 
	public static void ToXML(String s, String m) throws FileNotFoundException, TransformerException{
		DomParser = new XmlDOMParser();
		DOMdataSheet = new DOMDataSheet(DomParser.createDoc());
		parser = new XMLSAXParser();
		parser.getParse(s);
		int j = 0;
		Iterator<Data> i = parser.getDataSheet().getArr().iterator();
		while ( i.hasNext() ) {
			Data dat = parser.getDataSheet().getDataItem(j);
			DOMdataSheet.addElement(DOMdataSheet.newElement(dat.getDate(),dat.getX(), dat.getY()));
			i.next();
			j++;
		}
	XmlDOMParser.CastToXML(m, DOMdataSheet.getDoc());	
	}
	
	public static void main(String[] args) throws FileNotFoundException, TransformerException {
		ToXML("MyXML.xml", "Hello.xml");
	}
}
