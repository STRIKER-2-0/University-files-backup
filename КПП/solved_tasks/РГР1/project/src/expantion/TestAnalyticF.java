package expantion;

import java.util.InputMismatchException;

public class TestAnalyticF {

	public static void main(String[] args) {
		java.util.Scanner s = new java.util.Scanner(System.in);
		int ans;
		String expr;
		String var;
		String par="";
		AnalyticFunction f;
		
		System.out.print("\n������� ������� � ����������?\n1. ��\n2. ���\n��� �����: ");
		do {
			try {
				ans = s.nextInt();
				if(ans > 2 || ans < 1) {
					System.err.print("Uncorrect answer! Try again: ");
					continue;
				}
				break;
			}catch(InputMismatchException e) {
				System.err.print("Uncorrect answer! Try again: ");
				s.next();
			}
		}while(true);
		System.out.print("������� ���������� ��� �������: ");
		var = s.next();
		if(ans == 1) {
			System.out.print("������� �������� ��� �������: ");
			par = s.next();
		}
		System.out.print("������� �������: ");
		expr = s.next();
		if(ans == 1)
			f = new AnalyticFunction(expr, var, par);
		else f = new AnalyticFunction(expr, var);
		
		double point;
		while (true) {
			do {
				System.out.println("��������� �������: "+f.toString());	
				System.out.println("�������� ���������� ��������:\n"
						+ "1. ������������������� �������\n"
						+ "2. ����� �������� ������� � �����\n"
						+ "3. ����� ������������ �������� ����������� � �����\n"
						+ "4. ����� ������ ������� ����������� � �����\n"
						+ "5. ���������� �������� ���������\n"
						+ "6. ������ ����� �������\n"
						+ "7. ������ ����� ����������\n"
						+ "8. ������ ����� ��������\n"
						+ "9. �������� �������� � ����������\n"
						+ "0. �����");
				try {
					ans = s.nextInt();
					break;
				}catch(InputMismatchException e) {
					System.err.println("Uncorrect answer! Try again: ");
					s.next();
				}
			}while(true);
			switch(ans) {
			case 1: 
				System.out.println(SymbolNumMethods.symbolDif(f)); 
				break;
			case 2: 
				System.out.print("������� �������� �����: ");
				do {
					try {
						point = s.nextDouble();
						break;
					}catch(InputMismatchException e) {
						System.err.print("Uncorrect answer! Try again: ");
						s.next();
					}
				}while(true); 
				System.out.println(f.evalf(point));
				break;
			case 3: 
				System.out.print("������� �������� �����: ");
				do {
					try {
						point = s.nextDouble();
						break;
					}catch(InputMismatchException e) {
						System.err.print("Uncorrect answer! Try again: ");
						s.next();
					}
				}while(true); 
				System.out.println(SymbolNumMethods.dif(point, 1.0e-12, f));
				break;
			case 4: 
				System.out.print("������� �������� �����: ");
				do {
					try {
						point = s.nextDouble();
						break;
					}catch(InputMismatchException e) {
						System.err.print("Uncorrect answer! Try again: ");
						s.next();
					}
				}while(true); 
				System.out.println(SymbolNumMethods.strictDif(point, f));
				break;
			case 5: 
				System.out.print("������� �������� ���������: ");
				do {
					try {
						point = s.nextDouble();
						break;
					}catch(InputMismatchException e) {
						System.err.print("Uncorrect answer! Try again: ");
						s.next();
					}
				}while(true); 
				f.setParameterValue(point);
				break;
			case 6:
				System.out.println("������� ����� ���������: ");
				expr = s.next();
				f.setFunction(expr);
				break;
			case 7:
				System.out.println("������� ����� ����������: ");
				var = s.next();
				f.setVariable(var);
				break;
			case 8:
				System.out.println("������� ����� ��������: ");
				par = s.next();
				f.setParameter(par);
				break;
			case 9:
				f.swapVariableAndParameter();
				break;
			case 0: s.close(); System.out.println("---THE END---");return;
			default: System.err.println("Uncorrect answer! Try again: ");
			}			
		}
	}
}
