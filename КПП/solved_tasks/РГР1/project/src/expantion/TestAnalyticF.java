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
		
		System.out.print("\nÑîçäàòü ôóíêöèş ñ ïàğàìåòğîì?\n1. Äà\n2. Íåò\nÂàø âûáîğ: ");
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
		System.out.print("Ââåäèòå ïåğåìåííóş äëÿ ôóíêöèè: ");
		var = s.next();
		if(ans == 1) {
			System.out.print("Ââåäèòå ïàğàìåòğ äëÿ ôóíêöèè: ");
			par = s.next();
		}
		System.out.print("Ââåäèòå ôóíêöèş: ");
		expr = s.next();
		if(ans == 1)
			f = new AnalyticFunction(expr, var, par);
		else f = new AnalyticFunction(expr, var);
		
		double point;
		while (true) {
			do {
				System.out.println("Ââåäåííàÿ ôóíêöèÿ: "+f.toString());	
				System.out.println("Âûáåğèòå äàëüíåéøèå äåéñòâèÿ:\n"
						+ "1. Ïğîäèôôåğåíöèğîâàòü ôóíêöèş\n"
						+ "2. Íàéòè çíà÷åíèå ôóíêöèè â òî÷êå\n"
						+ "3. Íàéòè ïğèáëèæåííîå çíà÷åíèå ïğîèçâîäíîé â òî÷êå\n"
						+ "4. Íàéòè òî÷íîå çíà÷íèå ïğîèçâîäíîé â òî÷êå\n"
						+ "5. Óñòàíîâèòü çíà÷åíèå ïàğàìåòğà\n"
						+ "6. Ââåñòè íîâóş ôóíêöèş\n"
						+ "7. Ââåñòè íîâóş ïåğåìåííóş\n"
						+ "8. Ââåñòè íîâûé ïàğàìåòğ\n"
						+ "9. Ïîìåíÿòü ïàğàìåòğ è ïåğåìåííóş\n"
						+ "0. Âûõîä");
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
				System.out.print("Ââåäèòå çíà÷åíèå òî÷êè: ");
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
				System.out.print("Ââåäèòå çíà÷åíèå òî÷êè: ");
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
				System.out.print("Ââåäèòå çíà÷åíèå òî÷êè: ");
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
				System.out.print("Ââåäèòå çíà÷åíèå ïàğàìåòğà: ");
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
				System.out.println("Ââåäèòå íîâîå âûğàæåíèå: ");
				expr = s.next();
				f.setFunction(expr);
				break;
			case 7:
				System.out.println("Ââåäèòå íîâóş ïåğåìåííóş: ");
				var = s.next();
				f.setVariable(var);
				break;
			case 8:
				System.out.println("Ââåäèòå íîâûé ïàğàìåòğ: ");
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
