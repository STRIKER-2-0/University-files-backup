package expantion;

import consoleTasks.Evaluatable;
import consoleTasks.NumMethods;
import edu.hws.jcm.data.Expression;
import edu.hws.jcm.data.Parser;

public class SymbolNumMethods {
	private SymbolNumMethods() {
		
	}	
	public static double dif(double x, double epsilon, Evaluatable f) {
		return NumMethods.dif(x, epsilon, f);
	}
	public static double findRoot(double appr, double eps, Evaluatable f) {
		return NumMethods.findRoot(appr, eps, f);
	}	
	/**
	 * differentiate AnalyticFunction f symbolically
	 * @param f - AnalyticFunction that should be differentiate
	 * @return - String representation of differentiated function
	 */
	public static String symbolDif(AnalyticFunction f) {
		Parser p = new Parser(Parser.STANDARD_FUNCTIONS);
		p.add(f.getVariableObject());
		if(f.getParameterObject() != null) {
			p.add(f.getParameterObject());
		}
		Expression e = p.parse(f.toString());
		return e.derivative(f.getVariableObject()).toString();
	}	
	/**
	 * differentiate AnalyticFunction f numerically in the point x
	 * @param x - point, at which function should be differentiate
	 * @param f - AnalyticFunction that should be differentiate
	 * @return - String representation of differentiated function
	 */
	public static double strictDif(double x, AnalyticFunction f) {
		AnalyticFunction der;
		if(f.getParameter() != null) {
			der = new AnalyticFunction(symbolDif(f), f.getVariable(), f.getParameter());
		}
		else der = new AnalyticFunction(symbolDif(f), f.getVariable());
		return der.evalf(x);
	}	
}
