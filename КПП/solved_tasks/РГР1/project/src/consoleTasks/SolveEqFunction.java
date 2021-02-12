package consoleTasks;

public class SolveEqFunction implements Evaluatable {
	private LeftHand fun;
	private double epsilon;
	private double rootApprox;
	
	public SolveEqFunction() {
		fun = new LeftHand();
		epsilon = 1.0e-7;
		rootApprox = 0.0;
	}
	public double getEpsilon() {
		return epsilon;
	}
	public void setEpsilon(double epsilon) {
		this.epsilon = epsilon;
	}
	public void setRootApprox(double rootApprox) {
		this.rootApprox = rootApprox;
	}
	public double checkRoot(double x) {
		return fun.evalf(x);
	}
	
	@Override
	public double evalf(double x) {
		// TODO Auto-generated method stub
		fun.setA(x);
		rootApprox = NumMethods.findRoot(rootApprox, epsilon, fun);
		return rootApprox;
	}
	
	public static void main(String[] args) {
		SolveEqFunction fun = new SolveEqFunction();
		
		java.util.Scanner in = new java.util.Scanner(System.in);
		System.out.println("a: ");
		double a = in.nextDouble();
		System.out.println("xAppr: ");
		double xAppr = in.nextDouble();
		fun.setRootApprox(xAppr);
		double res = fun.evalf(a);
		System.out.println("Корень: " + res + "\tточность: " + fun.getEpsilon() + "\tf(root): " + fun.checkRoot(res));
		in.close();
	}

}
