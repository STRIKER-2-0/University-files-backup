import java.util.ArrayList;

public class Analyzer {
    private double k;
    private double b;

    public void analyze(ArrayList<Data> arrOfData){
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
}
