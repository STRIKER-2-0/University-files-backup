package xml;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import mybeans.Data;
import mybeans.DataSheet;

public class MyDataHandler extends DefaultHandler {	
	private DataSheet datasheet = null;
	private Data tmpData = null;
	private boolean isX, isY;
	
	public DataSheet getDataSheet() {
		return datasheet;
	}
	
	public void setDataSheet(DataSheet dsh) {
		this.datasheet = dsh;
	}

	@Override
	public void startDocument() throws SAXException {
		System.out.println("Start Document Parsing Process ...");
		if (datasheet == null) {
				datasheet = new DataSheet();
				datasheet.setName("DataSheet");				
		}
	}	
	@Override
	public void endDocument() throws SAXException {
		System.out.println("");
		System.out.println("End Document Parsing Process ...");
	}	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (qName.equals("data")) {
			tmpData = new Data();
			if (attributes.getLength() > 0) 
				tmpData.setDate(attributes.getValue(0));			
		} else if (qName.equals("x")) 
			isX = true;
		 else if (qName.equals("y")) 
			isY = true;		
	}	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equals("x")) 
			isX = false;
		else if (qName.equals("y")) 
			isY = false;
		else if (qName.equals("data")) {
			datasheet.addDataItem(tmpData);
			tmpData = null;
		}
	}	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String str = new String(ch, start, length).trim();
		if (isX) 
			tmpData.setX(Double.parseDouble(str));
		else if (isY) 
			tmpData.setY(Double.parseDouble(str));		
	}
}
