public class TestClass {
    private int num;
    public TestClass(){
        this.num=10;
    }
    public TestClass(int k){
        this.num=k;
    }
    public void PrintSmth(){
        System.out.println("sdfsa");
    }
    public double GetRes(double x,int y){
        return x+y;
    }
    public double GetRes(double x){
        return x*2;
    }
    public static double GetRes(){
        return 34;
    }
    private static void Do(){

    }
}
