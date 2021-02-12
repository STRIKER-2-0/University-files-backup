package expantion;

import java.util.Set;
import java.util.TreeSet;
import consoleTasks.Interpolator;
import consoleTasks.Point2D;

public class TreeSetInterpolation extends Interpolator {
	private Set<Point2D> data = null;
	
	
	public TreeSetInterpolation(Set<Point2D> data) {
		this.data = data;
	}
	public TreeSetInterpolation() {
		data = new TreeSet<Point2D>();
	}
	public TreeSetInterpolation(Point2D[] data) {
		this();
		for (Point2D point : data) {
			this.data.add(point);
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
		data.add(pt);
	}

	@Override
	public Point2D getPoint(int i) {
		return (Point2D) data.toArray()[i];
	}

	@Override
	public void setPoint(int i, Point2D pt) { //can't do this right
		data.add(pt);
	}

	@Override
	public void removeLastPoint() {
		data.remove(data.toArray()[data.size()-1]);
	}

	@Override
	public void sort() {
		//nothing, tree always sorted
	}
	
	public static void main(String[] args) {
		TreeSetInterpolation fun = new TreeSetInterpolation();
		int num;
		double x;
		java.util.Scanner in = new java.util.Scanner(System.in);
		
		do {
			System.out.print("���������� �����: ");
			num = in.nextInt();
		} while (num <= 0);
		
		for (int i = 0; i < num; i++) {
			x = 1.0 + (5.0 - 1.0)*Math.random();
			fun.addPoint(new Point2D(x, Math.sin(x)));
		}
		System.out.println("������������ ��: " + fun.numPoints() + " ������");
		System.out.println("��������������� �����: ");
		for (int i = 0; i < fun.numPoints(); i++) 
			System.out.println("����� " + (i+1) + ": " + fun.getPoint(i));
		
		fun.sort();
		System.out.println("��������������� �����: ");
		for (int i = 0; i < fun.numPoints(); i++) 
			System.out.println("����� " + (i+1) + ": " + fun.getPoint(i));
		
		System.out.println("����������� �������� �: " + fun.getPoint(0).getX());
		System.out.println("������������ �������� �: " + fun.getPoint(fun.numPoints()-1).getX());
		
		x = 0.5*(fun.getPoint(0).getX() + fun.getPoint(fun.numPoints()-1).getX());
		System.out.println("�������� ������������ fun(" + x + ") = " + fun.evalf(x));
		System.out.println("������ �������� sin(" + x + ") = " + Math.sin(x));
		System.out.println("���������� ������ = " + Math.abs(fun.evalf(x)-Math.sin(x)));
		
		in.close();
	}
}
