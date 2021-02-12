import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        SAXParserFactory spf=SAXParserFactory.newInstance();
        SAXParser saxparser;
        try {
            saxparser = spf.newSAXParser();
            Handler handler=new Handler();
            saxparser.parse(new File("data.xml"),handler);
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
