import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Date;

public class Handler extends DefaultHandler {

    private DataSheet dataSheet;
    private boolean xElement,yElement;
    private Data tmpData;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Начало обработки XML документа");
        xElement=false;yElement=false;
        dataSheet=new DataSheet();
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Конец обработки XML документа");
        System.out.println("Получена структура данных:");
        System.out.println(dataSheet);
//        k=(sumXY-sumX*sumY/count)/(sumXsqr-sumX*sumX/count);
//        b=sumY/count-k*sumX/count;
//        System.out.println("k= "+k+"\tb= "+b);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("x"))xElement=true;
        if (qName.equals("y"))yElement=true;
        if(qName.equals("data")){
            tmpData=new Data();
            tmpData.setDate(attributes.getValue(0));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("x")) xElement=false;
        if (qName.equals("y")) yElement=false;
        if (qName.equals("data")) dataSheet.addDataItem(tmpData);

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(xElement) tmpData.setX(Double.parseDouble(new String(ch,start,length)));
        if(yElement) tmpData.setY(Double.parseDouble(new String(ch,start,length)));

    }
    @Override
    public void warning(SAXParseException e) throws SAXException {
        System.out.println("Warning: "+e);
        System.out.println("Line: "+e.getLineNumber()+"\ncolum"+e.getColumnNumber());
        super.warning(e);
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
        System.out.println("Error: "+e);
        System.out.println("Line: "+e.getLineNumber()+"\ncolum"+e.getColumnNumber());
    }

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        System.out.println("Fatal Error: "+e);
        System.out.println("Line: "+e.getLineNumber()+"\ncolum"+e.getColumnNumber());
    }

    public DataSheet getDataSheet() {
        return dataSheet;
    }
}
