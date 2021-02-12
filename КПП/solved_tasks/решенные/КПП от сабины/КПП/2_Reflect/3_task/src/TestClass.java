public class TestClass {
    private Point p;
    private int k=3;
    public TestClass(Point p){
        this.p=p;
    }
    public TestClass(double p){
        this.p=new Point(p);
    }

    public Point getP() {
        return p;
    }

    public int getK() {
        return k;
    }

    public void setP(Point p) {
        this.p = p;
    }

    public void setK(int k) {
        this.k = k;
    }

    @Override
    public String toString() {
        System.out.println("ok");
        return super.toString();
    }
}
