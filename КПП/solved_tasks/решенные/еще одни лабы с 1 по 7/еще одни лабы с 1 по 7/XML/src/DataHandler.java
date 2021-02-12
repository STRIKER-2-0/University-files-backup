import org.xml.sax.Attributes;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class DataHandler extends DefaultHandler implements ErrorHandler{
	private boolean isX, isY;
	private double sumX,sumY,sumX2,sumXY,t;
	private double k,b;
	private int num;

	@Override
	public void startDocument() throws SAXException {
		System.out.println("Start parcing...");
		sumX=0; sumY=0; sumX2=0; sumXY=0; t=0; num=0;
		//super.startDocument();
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("End parcing...");
		num /= 2;
		k = (sumXY - sumX*sumY/num)/(sumX2 - sumX*sumX/num);
		b = sumY/num - k*sumX/num;
		System.out.println("k: " + k + "\t" + "b: " + b);
		//super.endDocument();
	}
	
	@Override
	public void startElement(String arg0, String arg1, String arg2, Attributes arg3) 
			throws SAXException {
		System.out.println("Element " + arg2 + " processing...");
		if(arg2.equals("x")) {
			isX = true;
		} else if(arg2.equals("y")) {
			isY= true;
		}
		if(arg3.getLength() > 0) {
			for(int i = 0; i<arg3.getLength(); i++)
				System.out.println("\t" + arg3.getLocalName(i) + ": " + arg3.getValue(i));
		}
		//super.startElement(arg0, arg1, arg2, arg3);
	}

	@Override
	public void endElement(String arg0, String arg1, String arg2) throws SAXException {
		System.out.println("Element " + arg2 + " end processing");
		if(arg2.equals("x")) {
			isX = false;
			num+=1;
		} else if(arg2.equals("y")) {
			isY = false;
			t = 0;
			num+=1;
		}
		//super.endElement(arg0, arg1, arg2);
	}

	@Override
	public void characters(char[] arg0, int arg1, int arg2) throws SAXException {
		String str = new String(arg0, arg1, arg2).trim();
		if(str.trim().length() >0) {
			System.out.println("\tValue: " + str);
		}
		double tmp = 0;
		if(isX) {
			tmp = Double.parseDouble(str);
			sumX += tmp;
			sumX2 += tmp*tmp;
			t = tmp;
		}else if(isY) {
			tmp = Double.parseDouble(str);
			sumY += tmp;
			t = t*tmp;
			sumXY +=t;
		}
		//super.characters(arg0, arg1, arg2);
	}
}
