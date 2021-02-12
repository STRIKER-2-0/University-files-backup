package consoleTasks;

public class NumMethods {
	
	private NumMethods() {
		
	}
	
	private static double difWithH(double x, double h, Evaluatable f) {
		return 0.5*(f.evalf(x+h) - f.evalf(x-h))/h;
	}
	public static double dif(double x, double epsilon, Evaluatable f) {
		final int MAX = 100;
		double h = 0.1;
		double one = difWithH(x, h, f);
		h = 0.1*h;
		double two = difWithH(x, h, f);
		int i = 0;
		double next;
		boolean stop;
		do {
			h = 0.1*h;
			next = difWithH(x, h, f);
			stop = (Math.abs(next-two) >= Math.abs(two-one)) || (Math.abs(two-one) < epsilon);
			if (i > MAX) {
				System.out.print("Слишком много шагов вычислений");
				System.exit(-1);
			}
			i += 1;
			one = two;
			two = next;
		} while (!stop);
		return two;
	}
	public static double findRoot(double appr, double eps, Evaluatable f) {
		final int MAX_ITER = 100;
		int k = 0;
		double delta = 1.0e-1*appr;
		double old1 = appr, old2 = appr + delta;
		double res, error;
		do {
			k += 1;
			res = old2 - f.evalf(old2) * (old1 - old2) / (f.evalf(old1) - f.evalf(old2));
			error = Math.abs(res - old2);
			old1 = old2;
			old2 = res;
			if (k > MAX_ITER) {
				System.out.print("Слишком много шагов вычислений");
				System.exit(-1);
			}
		} while (error >= eps);
		return res;
	}
	public static void main(String[] args) {
		//проверка метода решения уравнения
		double resEq1, resEq2;
		
		resEq1 = NumMethods.findRoot(2.0, 1.0e-7, new Evaluatable() {
			public double evalf(double x) {return x*x - 5;}
		});
		resEq2 = NumMethods.findRoot(-1.0, 1.0e-7, new Evaluatable() {
			public double evalf(double x) {return x*x - 4;}
		});
		
		System.out.println("Первый корень: " + resEq1 + "\nВторой корень: " + resEq2);
		
		//проверка метода дифференцирования
		ListInterpolation fun = new ListInterpolation();
		
		int num;
		double x = -0.5*Math.PI;
		double step = 0.1;
		java.util.Scanner in = new java.util.Scanner(System.in);
		
		do {
			System.out.print("Количество точек: ");
			num = in.nextInt();
		} while (num <= 0);
		
		for (int i = 0; i < num; i++) {
			x += step;
			fun.addPoint(new Point2D(x, Math.sin(x)));
		}
		
		x = 0.5*(fun.getPoint(0).getX() + fun.getPoint(fun.numPoints()-1).getX());
		double res = NumMethods.dif(x, 1.0e-5, fun);
		System.out.println("Численное значение sin'(" + x + ") = " + res);
		System.out.println("Символьное значение sin'(" + x + ") = " + Math.cos(x));
		System.out.println("Абсолютная ошибка = " + Math.abs(res-Math.cos(x)));
		in.close();
	}

}
