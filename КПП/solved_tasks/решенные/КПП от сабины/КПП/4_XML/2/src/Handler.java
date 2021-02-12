import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
public class Handler extends DefaultHandler {
    private boolean xElement,yElement;
    private double sumXY,sumX,sumY,sumXsqr,k,b,tmp;
    private int count;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Начало обработки XML документа");
        xElement=false;yElement=false;
        sumXY=0;sumX=0;sumY=0;sumXsqr=0;
        count=0;
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Конец обработки XML документа");
        k=(sumXY-sumX*sumY/count)/(sumXsqr-sumX*sumX/count);
        b=sumY/count-k*sumX/count;
        System.out.println("k= "+k+"\tb= "+b);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Начало обработки элемента "+qName);
        if (qName.equals("x"))xElement=true;
        if(qName.equals("y"))yElement=true;
        for(int i=0;i<attributes.getLength();i++)
            System.out.println("Атрибут "+attributes.getQName(i)+" значение: "+attributes.getValue(i));
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("Конец обработки элемента "+qName);
        if (qName.equals("x")){xElement=false;count++;}
        if(qName.equals("y"))yElement=false;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        double num=0;
        if(xElement){
            num=Double.parseDouble(new String(ch,start,length));
            System.out.println("Значение= "+num);
            sumX+=num;
            sumXsqr+=Math.pow(num,2);
            tmp=num;
        }
        if(yElement){
            num=Double.parseDouble(new String(ch,start,length));
            System.out.println("Значение= "+num);
            sumY+=num;
            sumXY+=tmp*num;
        }
    }
}
