import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.ArrayList;

public class Analyzer {
    private double k;
    private double b;
    private ArrayList<Data> arrOfData;

    public Analyzer(ArrayList<Data> arrOfData) {
        this.arrOfData = arrOfData;
    }

    public void setArrOfData(ArrayList<Data> arrOfData) {
        this.arrOfData = arrOfData;
    }

    public void analyze(){
        double sumXY=0,sumX=0,sumY=0,sumXsqr=0;
        for (Data d:arrOfData){
            sumX+=d.getX();
            sumXsqr+=Math.pow(d.getX(),2);
            sumXY+=d.getX()*d.getY();
            sumY+=d.getY();
        }
        k=(sumXY-sumX*sumY/arrOfData.size())/(sumXsqr-sumX*sumX/arrOfData.size());
        b=sumY/arrOfData.size()-k*sumX/arrOfData.size();

    }

    public double getK() {
        return k;
    }

    public double getB() {
        return b;
    }

    public Document converArrToDocument() throws ParserConfigurationException {
        DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder=dbf.newDocumentBuilder();
        Document doc=docBuilder.newDocument();
        Element root=doc.createElement("AnalyzeData");

        Element tmp=doc.createElement("DataTable");

        Element child;
        Element tmpXY;
        for(Data data:arrOfData){
            child=doc.createElement("dataPoint");
            child.setAttribute("date",data.getDate());

            tmpXY=doc.createElement("x");
            tmpXY.appendChild(doc.createTextNode(String.valueOf(data.getX())));
            child.appendChild(tmpXY);

            tmpXY=doc.createElement("y");
            tmpXY.appendChild(doc.createTextNode(String.valueOf(data.getY())));
            child.appendChild(tmpXY);

            tmp.appendChild(child);
        }
        root.appendChild(tmp);


        tmp=doc.createElement("line");
        tmp.setAttribute("b",String.valueOf(b));
        tmp.setAttribute("k",String.valueOf(k));
        root.appendChild(tmp);

        doc.appendChild(root);
        return doc;
    }
}
