package lab4;
import java.util.Scanner;

public class Main {
	public static boolean flag=false;
	public static Vehicle car=new Vehicle(10,40);
	public static Bus bus=new Bus(10,20,30,50);
	public static Truck truck=new Truck(10,20,30,50);
	public static Scanner scan=new Scanner(System.in);
	public static void main(String[] ags) {
		
					
		int ans;
		
		while(true) {
			System.out.println("\n1.Управление машиной\n2.Управление автобусом\n3.Управление грузовиком\n4.Информация о базе\n5.Выход");
			ans=scan.nextInt();
			switch(ans) {
				case 1:
					use_car(); 
					break;
				case 2: 
					use_bus(); 
					break;
				case 3:
					use_truck();
					break;
				case 4: Base.info(); break;
				case 5: System.out.println("---Конец теста---"); scan.close(); return;
				default:  System.out.println("Некорректные данные!");
			}
		}
		
	}
	public static void use_car() {
		int ans;
		double c,d;
		
		while(true) {
			System.out.println("\n1.Создать машину\n2.Приехать на базу\n3.Уехать с базы\n4.Уровень топлива в баке\n5.Объем топливного бака\n6.В предыдущее меню");
			ans=scan.nextInt();
			switch(ans) {
				case 1:	System.out.print("Введите кол-во топлива в баке: ");
						c=scan.nextDouble();
						System.out.print("Введите объём бака: ");
						d=scan.nextDouble();
						car=new Vehicle(c,d);
						flag=true;
						break;
				case 2: if(flag==false)
							System.out.println("Машина не создана!");
						else { 
							car.arrive();
							
						}
						break;
				case 3: if(flag==false)
							System.out.println("Машина не создана!");
						else {
							if(!car.leave())
								System.out.println("Трансп. средство не может уехать! Не достаточно топлива и/или отсутствует водитель.");								
						} 
						break;
				case 4: if(flag==false)
							System.out.println("Машина не создана!");
						else 
							System.out.println("Уровень топлива в баке: "+car.getPetrolAmount());
						break;
				case 5: if(flag==false)
							System.out.println("Машина не создана!");
						else 
							System.out.println("Объем топливного бака: "+car.getTankVolume());
						break;
				case 6: return;
				default: System.out.println("Некорректные данные!");
			}
		}
	}
	public static void use_bus() {
		int ans,a,b;
		double c,d;
		
		while(true) {
			System.out.println("\n1.Создать машину\n2.Приехать на базу\n3.Уехать с базы\n4.Кол-во пассажиров\n5.Кол-во мест\n6.Уровень топлива в баке\n7.Объем топливного бака\n8.В предыдущее меню");
			ans=scan.nextInt();
			switch(ans) {
				case 1:	System.out.print("Введите кол-во пассажиров: ");
						a=scan.nextInt();
						System.out.print("Введите кол-во мест: ");
						b=scan.nextInt();
						System.out.print("Введите кол-во топлива в баке: ");
						c=scan.nextDouble();
						System.out.print("Введите объём бака: ");
						d=scan.nextDouble();
						bus=new Bus(a,b,c,d);
						flag=true;
						break;
				case 2: if(flag==false)
							System.out.println("Машина не создана!");
						else { 
							bus.arrive();							
						}
						break;
				case 3: if(flag==false)
							System.out.println("Машина не создана!");
						else {
							if(!bus.leave())
								System.out.println("Трансп. средство не может уехать! Не достаточно топлива и/или отсутствует водитель.");								
						} 
						break;
				case 4: if(flag==false)
							System.out.println("Машина не создана!");
						else 
							System.out.println("Кол-во пассажиров: "+bus.getPeopleCount());
						break;
				case 5: if(flag==false)
							System.out.println("Машина не создана!");
						else 
							System.out.println("Кол-во мест: "+bus.getMaxPeople());
				break;
				case 6: if(flag==false)
							System.out.println("Машина не создана!");
						else 
							System.out.println("Уровень топлива в баке: "+bus.getPetrolAmount());
						break;
				case 7: if(flag==false)
							System.out.println("Машина не создана!");
						else 
							System.out.println("Объем топливного бака: "+bus.getTankVolume());
						break;
				case 8: return;
				default: System.out.println("Некорректные данные!");
			}
		}
	}
	public static void use_truck() {
		int ans;
		double a,b,c,d;
		
		while(true) {
			System.out.println("\n1.Создать машину\n2.Приехать на базу\n3.Уехать с базы\n4.Кол-во груза\n5.Макс. грузоподъёмность\n6.Уровень топлива в баке\n7.Объем топливного бака\n8.В предыдущее меню");
			ans=scan.nextInt();
			switch(ans) {
				case 1:	System.out.print("Введите кол-во груза: ");
						a=scan.nextDouble();
						System.out.print("Введите макс. грузоподъёмност: ");
						b=scan.nextDouble();
						System.out.print("Введите кол-во топлива в баке: ");
						c=scan.nextDouble();
						System.out.print("Введите объём бака: ");
						d=scan.nextDouble();
						truck=new Truck(a,b,c,d);
						flag=true;
						break;
				case 2: if(flag==false)
							System.out.println("Машина не создана!");
						else { 
							truck.arrive();							
						}
						break;
				case 3: if(flag==false)
							System.out.println("Машина не создана!");
						else {
							if(!truck.leave())
								System.out.println("Трансп. средство не может уехать! Не достаточно топлива и/или отсутствует водитель.");								
						} 
						break;
				case 4: if(flag==false)
							System.out.println("Машина не создана!");
						else 
							System.out.println("Кол-во груза: "+truck.getCurrentLoad());
						break;
				case 5: if(flag==false)
							System.out.println("Машина не создана!");
						else 
							System.out.println("Макс. грузоподъёмност: "+truck.getMaxLoad());
				break;
				case 6: if(flag==false)
							System.out.println("Машина не создана!");
						else 
							System.out.println("Уровень топлива в баке: "+truck.getPetrolAmount());
						break;
				case 7: if(flag==false)
							System.out.println("Машина не создана!");
						else 
							System.out.println("Объем топливного бака: "+truck.getTankVolume());
						break;
				case 8: return;
				default: System.out.println("Некорректные данные!");
			}
		}
	}
}
