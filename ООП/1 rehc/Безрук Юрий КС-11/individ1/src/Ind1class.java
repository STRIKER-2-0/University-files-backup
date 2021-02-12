
public class Ind1class {
	public static void main(String args[]){
		int x;
		System.out.println("x\tF(x)\t\t S(x)");
		for(x=0; x<=10; x++){
			System.out.print(x+"\t");
			System.out.printf("%.6f\t",F(x));//форматирванный вывод: ограничение на 6 знаков после запятой
			System.out.printf("%.6f\n",S(x));
		}
		
	}
	public static double F(int x){		//F(x)-сумма ряда
		double E=Math.pow(10, -6);
		double result=0;
		double member=1;
		for(int k=1; member>E; k++){
			member=Math.pow(-1, k+1)*((Math.pow(2, 2*k-1)*Math.pow(x, 2*k))/fact(2*k));
			result+=member;
		}
		return result;
	}
	public static double S(int x) {		//S(x)-суперпозиция
		return F(x)-Math.sin(x)*Math.sin(x);
	}
	public static int fact(int n){		//факториал числа через рекурсию
		if(n==0) return 1;
		else if(n==1) return 1;
		else return n*fact(n-1);
		
	}
}
