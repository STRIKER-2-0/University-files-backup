class Data{
    private double x;
    private double y;
    private String date;

    public Data(){
        x=0;y=0;
        date="";
    }

    public Data(String date, double x, double y) {
        this.x = x;
        this.y = y;
        this.date = date;
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

    public String toString() {
        return "Date: "+date+" x: "+x+" y: "+y;
    }
}