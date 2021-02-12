import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

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
		System.out.println("\t");
		System.out.println("\t"+datasheet.getName());
		System.out.println("End Document Parsing Process ...");
	}
	
	@Override
	public void startElement(String arg0, String arg1, String arg2, Attributes arg3) 
			throws SAXException {
		if (arg2.equals("data")) {
			tmpData = new Data();
			if (arg3.getLength() > 0) {
				tmpData.setDate(arg3.getValue(0));
			}
		} else if (arg2.equals("x")) {
			isX = true;
		} else if (arg2.equals("y")) {
			isY = true;
		}
	}
	
	@Override
	public void endElement(String arg0, String arg1, String arg2)
			throws SAXException {
		if (arg2.equals("x")) {
			isX = false;
		} else if (arg2.equals("y")) {
			isY = false;
		} else if (arg2.equals("data")) {
			datasheet.addDataItem(tmpData);
			tmpData = null;
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		String str = new String(ch, start, length).trim();
		if (isX) {
			tmpData.setX(Double.parseDouble(str));
		} else if (isY) {
			tmpData.setY(Double.parseDouble(str));
		}
	}
}
