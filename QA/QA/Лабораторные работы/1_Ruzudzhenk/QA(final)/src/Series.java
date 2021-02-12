import java.util.Scanner;

public class Series {

    public static double  findSum (double e) {
        double result = 0;

        for (int i = 1; result < e; i++) {
            result += 1 / (i * (i + 1));

            System.out.format("%.3f", result);
        }
        return Math.floor(result);
    }
    public static void main (String[] args) {
        double E;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter E");
        E = sc.nextDouble();
        findSum(E);
    }
}