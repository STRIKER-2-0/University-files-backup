public class ExamTesting {
    public static void main(String[] args) {
        System.out.println("x\t\tS(x)\t\tF(x)\tS(x)-F(x)");
        for(int x = 0; x <= 10; x++){   //виконуємо табуляцію значень х та функцій F(x), S(x) на діапазоні  0(1)10
            System.out.print(x+"\t");
            System.out.printf("%.6f\t", F(x));
            System.out.printf("%.6f\t", S(x));
            System.out.printf("%.6f\n", S(x)-F(x));
        }
    }
    public static double F(double x) {   //реалізація функції F(x)
        double E = Math.pow(10, -6);    //задаємо похибку наближення
        double result = 0;       //змінна для кінцевого результату
        double member = 1;       //змінна для кожного члену ряду
        for (int k = 1; member > E; k++) {      //обчислюємо суму допоки кожен наступний член ряду більший за погрішність
            member = Math.pow(-1, k + 1) * Math.pow(2, 2 * k - 1) * Math.pow(x, 2 * k) / factorial(2 * k);
            result += member;     //додаємо до результату кожен обчислений член
        }
        return result;
    }
    public static double S(double x){   //реалізація функції S(x)
        return F(x)-Math.pow(Math.sin(x), 2);   //віднімаємо від F(x) квадрат синуса
    }
    public static int factorial(int n) {   //функція для обчислення факторіалу
        if(n==0)
            return 1;
        if(n==1)
            return 1;
        else return n*factorial(n-1);
    }
}
