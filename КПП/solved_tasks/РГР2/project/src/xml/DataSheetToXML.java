package xml;
import java.io.FileNotFoundException;
import java.util.Iterator;

import javax.xml.transform.TransformerException;

import mybeans.Data;
import mybeans.DataSheet;

public class DataSheetToXML {
	private static DOMDataSheet DOMdataSheet;
	
	 
	public static void ToXML(DataSheet datasheet, String s) throws FileNotFoundException, TransformerException{
		DOMdataSheet = new DOMDataSheet(XmlDOMParser.createDoc());
		int j = 0;
		Iterator<Data> i = datasheet.getArr().iterator();
		while ( i.hasNext() ) {
			Data dat = datasheet.getDataItem(j);
			DOMdataSheet.addElement(DOMdataSheet.newElement(dat.getDate(),dat.getX(), dat.getY()));
			i.next();
			j++;
		}
		XmlDOMParser.CastToXML(s, DOMdataSheet.getDoc());	
	}
	
}
