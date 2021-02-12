package consoleTasks;
import java.io.*;

public class DerivativeApplication {
	public static void main(String[] args) throws IOException {
		Evaluatable functs[] = new Evaluatable[4];
		functs[0] = new FFunction();
		functs[1] = new FFunction(0.5);
		functs[2] = new SolveEqFunction();
		functs[3] = new FileListInterpolation();
		
		((SolveEqFunction)functs[2]).setRootApprox(0.7);
		
		try {
			((FileListInterpolation)functs[3]).readFromFile("TblFunc.dat");
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		
		String filename = "";
		for (Evaluatable f : functs) {
			filename = f.getClass().getSimpleName();
			if(f.getClass().equals(FFunction.class))
				filename += "(a=" + ((FFunction)f).getA() + ")";
			System.out.println("функция: " + filename);
			filename += ".dat";
			PrintWriter out = new PrintWriter(new FileWriter(filename));
			for (double x = 1.5; x <= 6.5; x +=0.05) {
				System.out.println("x: " + x + "\tf: " + f.evalf(x) + "\tf': " + NumMethods.dif(x, 1.0e-4, f));
				out.printf("%16.6e%16.6e%16.6e\n", x, f.evalf(x), NumMethods.dif(x, 1.0e-4, f));
			}
			System.out.println("\n");
			out.close();
		}
	}
}
