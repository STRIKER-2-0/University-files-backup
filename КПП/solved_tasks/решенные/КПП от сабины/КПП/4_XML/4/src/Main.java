import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        SAXParserFactory spf=SAXParserFactory.newInstance();
        spf.setValidating(true);
        spf.setNamespaceAware(true);
        SAXParser saxparser;
        try {
            saxparser = spf.newSAXParser();
            saxparser.setProperty("http://java.sun.com/xml/jaxp/properties/schemaLanguage","http://www.w3.org/2001/XMLSchema");
            Handler handler=new Handler();
            saxparser.parse(new File("data.xml"),handler);

            Analyzer analyzer=new Analyzer();
            analyzer.analyze(handler.getDataSheet().getArrOfData());
            System.out.println("k= "+analyzer.getK()+"\tb= "+analyzer.getB());
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
//    SAXParserFactory spf=SAXParserFactory.newInstance();
//
//    SAXParser saxparser;
//
//    {
//        try {
//            saxparser = spf.newSAXParser();
//            Handler handler=new Handler();
//            saxparser.parse(new File("data.xml"),handler);
//        } catch (ParserConfigurationException e) {
//            e.printStackTrace();
//        } catch (SAXException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

}
