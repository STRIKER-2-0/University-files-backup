package xml;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import mybeans.DataSheet;

public class XMLSAXParser {
	private static DataSheet datasheet;
	
	public static DataSheet getParse(String fileName){
		SAXParserFactory factory = SAXParserFactory.newInstance();
		MyDataHandler handler = new MyDataHandler();
		SAXParser parser;
		try {
			parser = factory.newSAXParser();
			InputStream xmlInput = new FileInputStream(fileName);
			parser.parse(xmlInput, handler);
			datasheet = handler.getDataSheet();
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}		
		return datasheet;
	}
	
	public static DataSheet getDataSheet() {
		return datasheet;
	}
}
