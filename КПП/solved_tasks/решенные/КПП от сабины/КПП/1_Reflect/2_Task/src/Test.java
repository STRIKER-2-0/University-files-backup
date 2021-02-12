public class Test {
    private double x;
    public double y;

    public Test(){
        x=5;
        y=2;
    }

    public double Dist(){
        return Math.sqrt(x*x+y*y);
    }

    @Override
    public String toString() {
        return "Test{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
