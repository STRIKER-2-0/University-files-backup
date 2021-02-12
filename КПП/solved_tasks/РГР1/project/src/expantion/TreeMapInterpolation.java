package expantion;
import java.util.Map;
import java.util.TreeMap;
import consoleTasks.Interpolator;
import consoleTasks.Point2D;
public class TreeMapInterpolation extends Interpolator {
	private Map<Double, Double> data = null;
	
	public TreeMapInterpolation(Map<Double, Double> data) {
		this.data = data;
	}
	public TreeMapInterpolation() {
		data = new TreeMap<Double, Double>();
	}
	public TreeMapInterpolation(Point2D[] data) {
		this();
		for (Point2D point : data) {
			this.data.put(point.getX(), point.getY());
		}
	}
	@Override
	public void clear() {
		data.clear();
	}
	@Override
	public int numPoints() {
		return data.size();
	}
	@Override
	public void addPoint(Point2D pt) {
		data.put(pt.getX(), pt.getY());
	}
	@Override
	public Point2D getPoint(int i) {
		Double x = (Double) data.keySet().toArray()[i];
		return new Point2D(x, data.get(x));
	}
	@Override
	public void setPoint(int i, Point2D pt) {
		data.remove(data.keySet().toArray()[i]);
		data.put(pt.getX(), pt.getY());
	}
	@Override
	public void removeLastPoint() {
		data.remove(data.keySet().toArray()[data.size()-1]);
	}	
	@Override
	public void sort() {

	}	
	public Double getX(int i) {
		return (Double) data.keySet().toArray()[i];
	}
	public Double getYbyX (Double x) {
		return data.get(x);
	}
	public static void main(String[] args) {
		TreeMapInterpolation fun = new TreeMapInterpolation();
		int num;
		double x;
		java.util.Scanner in = new java.util.Scanner(System.in);
		
		do {
			System.out.print("Количество точек: ");
			num = in.nextInt();
		} while (num <= 0);
		
		for (int i = 0; i < num; i++) {
			x = 1.0 + (5.0 - 1.0)*Math.random();
			fun.addPoint(new Point2D(x, Math.sin(x)));
		}
		System.out.println("Интерполяция по: " + fun.numPoints() + " точкам");
		System.out.println("Несортированный набор: ");
		for (int i = 0; i < fun.numPoints(); i++) 
			System.out.println("Точка " + (i+1) + ": " + fun.getPoint(i));
		
		fun.sort();
		System.out.println("Отсортированный набор: ");
		for (int i = 0; i < fun.numPoints(); i++) 
			System.out.println("Точка " + (i+1) + ": " + fun.getPoint(i));
		
		System.out.println("Минимальное значение х: " + fun.getPoint(0).getX());
		System.out.println("Максимальное значение х: " + fun.getPoint(fun.numPoints()-1).getX());
		
		x = 0.5*(fun.getPoint(0).getX() + fun.getPoint(fun.numPoints()-1).getX());
		System.out.println("Значение интерполяции fun(" + x + ") = " + fun.evalf(x));
		System.out.println("Точное значение sin(" + x + ") = " + Math.sin(x));
		System.out.println("Абсолютная ошибка = " + Math.abs(fun.evalf(x)-Math.sin(x)));
		
		in.close();
	}
}
