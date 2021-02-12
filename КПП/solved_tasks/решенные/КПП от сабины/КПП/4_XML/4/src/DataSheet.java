import java.util.ArrayList;
import java.util.Date;

public class DataSheet {
    ArrayList<Data> arrOfData;

    public DataSheet(){
        arrOfData=new ArrayList<>();
    }

    public void addDataItem(Data data) {
        this.arrOfData.add(data);
    }

    public ArrayList<Data> getArrOfData() {
        return arrOfData;
    }

    @Override
    public String toString() {
        StringBuilder str=new StringBuilder();
        for(Data d:arrOfData) str.append(d+"\n");
        return str.toString();
    }
}
class Data{
    private double x;
    private double y;
    private String date;

    public Data(){
        x=0;y=0;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setDate(String date){
        this.date=date;
    }

    public double getX() {
                                                                       
        return x;                                                      
    }                                                                  
                                                                       
    public double getY() {                                             
        return y;                                                      
    }                                                                  
                                                                       
    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Дата: "+date+" x: "+x+" y: "+y;
    }
}
