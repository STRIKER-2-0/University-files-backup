import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class XMLSAXParser {
	private DataSheet datasheet;
	
	public void getParse(String s){
		SAXParserFactory factory = SAXParserFactory.newInstance();
		factory.setValidating(true);
		MyDataHandler handler = new MyDataHandler();
		try{
			SAXParser parser = factory.newSAXParser();
			//parser.setProperty("http://java.sun.com/xml/jaxp/properties/schemaLanguage",
				//	"http://www.w3.org/2001/XMLSchema");
			InputStream xmlInput = new FileInputStream(s);
			parser.parse(xmlInput, handler);
			datasheet = handler.getDataSheet();
			System.out.println(datasheet);
		}
		catch(Exception e){
		}
	}
	
	public DataSheet getDataSheet() {
		return this.datasheet;
	}

}
