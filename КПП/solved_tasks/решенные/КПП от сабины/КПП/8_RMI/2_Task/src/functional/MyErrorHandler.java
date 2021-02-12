package functional;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class MyErrorHandler implements ErrorHandler {
    public void warning(SAXParseException exception) throws SAXException {
        System.out.println("Fatal Error: "+exception);
        System.out.println("Line: "+exception.getLineNumber()+"\ncolum: "+exception.getColumnNumber());
    }

    public void error(SAXParseException exception) throws SAXException {
        System.out.println("Fatal Error: "+exception);
        System.out.println("Line: "+exception.getLineNumber()+"\ncolum: "+exception.getColumnNumber());
    }

    public void fatalError(SAXParseException exception) throws SAXException {
        System.out.println("Fatal Error: "+exception);
        System.out.println("Line: "+exception.getLineNumber()+"\ncolum: "+exception.getColumnNumber());
    }
}
