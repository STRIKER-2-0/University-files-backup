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
			System.out.println("\n1.���������� �������\n2.���������� ���������\n3.���������� ����������\n4.���������� � ����\n5.�����");
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
				case 5: System.out.println("---����� �����---"); scan.close(); return;
				default:  System.out.println("������������ ������!");
			}
		}
		
	}
	public static void use_car() {
		int ans;
		double c,d;
		
		while(true) {
			System.out.println("\n1.������� ������\n2.�������� �� ����\n3.������ � ����\n4.������� ������� � ����\n5.����� ���������� ����\n6.� ���������� ����");
			ans=scan.nextInt();
			switch(ans) {
				case 1:	System.out.print("������� ���-�� ������� � ����: ");
						c=scan.nextDouble();
						System.out.print("������� ����� ����: ");
						d=scan.nextDouble();
						car=new Vehicle(c,d);
						flag=true;
						break;
				case 2: if(flag==false)
							System.out.println("������ �� �������!");
						else { 
							car.arrive();
							
						}
						break;
				case 3: if(flag==false)
							System.out.println("������ �� �������!");
						else {
							if(!car.leave())
								System.out.println("������. �������� �� ����� ������! �� ���������� ������� �/��� ����������� ��������.");								
						} 
						break;
				case 4: if(flag==false)
							System.out.println("������ �� �������!");
						else 
							System.out.println("������� ������� � ����: "+car.getPetrolAmount());
						break;
				case 5: if(flag==false)
							System.out.println("������ �� �������!");
						else 
							System.out.println("����� ���������� ����: "+car.getTankVolume());
						break;
				case 6: return;
				default: System.out.println("������������ ������!");
			}
		}
	}
	public static void use_bus() {
		int ans,a,b;
		double c,d;
		
		while(true) {
			System.out.println("\n1.������� ������\n2.�������� �� ����\n3.������ � ����\n4.���-�� ����������\n5.���-�� ����\n6.������� ������� � ����\n7.����� ���������� ����\n8.� ���������� ����");
			ans=scan.nextInt();
			switch(ans) {
				case 1:	System.out.print("������� ���-�� ����������: ");
						a=scan.nextInt();
						System.out.print("������� ���-�� ����: ");
						b=scan.nextInt();
						System.out.print("������� ���-�� ������� � ����: ");
						c=scan.nextDouble();
						System.out.print("������� ����� ����: ");
						d=scan.nextDouble();
						bus=new Bus(a,b,c,d);
						flag=true;
						break;
				case 2: if(flag==false)
							System.out.println("������ �� �������!");
						else { 
							bus.arrive();							
						}
						break;
				case 3: if(flag==false)
							System.out.println("������ �� �������!");
						else {
							if(!bus.leave())
								System.out.println("������. �������� �� ����� ������! �� ���������� ������� �/��� ����������� ��������.");								
						} 
						break;
				case 4: if(flag==false)
							System.out.println("������ �� �������!");
						else 
							System.out.println("���-�� ����������: "+bus.getPeopleCount());
						break;
				case 5: if(flag==false)
							System.out.println("������ �� �������!");
						else 
							System.out.println("���-�� ����: "+bus.getMaxPeople());
				break;
				case 6: if(flag==false)
							System.out.println("������ �� �������!");
						else 
							System.out.println("������� ������� � ����: "+bus.getPetrolAmount());
						break;
				case 7: if(flag==false)
							System.out.println("������ �� �������!");
						else 
							System.out.println("����� ���������� ����: "+bus.getTankVolume());
						break;
				case 8: return;
				default: System.out.println("������������ ������!");
			}
		}
	}
	public static void use_truck() {
		int ans;
		double a,b,c,d;
		
		while(true) {
			System.out.println("\n1.������� ������\n2.�������� �� ����\n3.������ � ����\n4.���-�� �����\n5.����. ����������������\n6.������� ������� � ����\n7.����� ���������� ����\n8.� ���������� ����");
			ans=scan.nextInt();
			switch(ans) {
				case 1:	System.out.print("������� ���-�� �����: ");
						a=scan.nextDouble();
						System.out.print("������� ����. ���������������: ");
						b=scan.nextDouble();
						System.out.print("������� ���-�� ������� � ����: ");
						c=scan.nextDouble();
						System.out.print("������� ����� ����: ");
						d=scan.nextDouble();
						truck=new Truck(a,b,c,d);
						flag=true;
						break;
				case 2: if(flag==false)
							System.out.println("������ �� �������!");
						else { 
							truck.arrive();							
						}
						break;
				case 3: if(flag==false)
							System.out.println("������ �� �������!");
						else {
							if(!truck.leave())
								System.out.println("������. �������� �� ����� ������! �� ���������� ������� �/��� ����������� ��������.");								
						} 
						break;
				case 4: if(flag==false)
							System.out.println("������ �� �������!");
						else 
							System.out.println("���-�� �����: "+truck.getCurrentLoad());
						break;
				case 5: if(flag==false)
							System.out.println("������ �� �������!");
						else 
							System.out.println("����. ���������������: "+truck.getMaxLoad());
				break;
				case 6: if(flag==false)
							System.out.println("������ �� �������!");
						else 
							System.out.println("������� ������� � ����: "+truck.getPetrolAmount());
						break;
				case 7: if(flag==false)
							System.out.println("������ �� �������!");
						else 
							System.out.println("����� ���������� ����: "+truck.getTankVolume());
						break;
				case 8: return;
				default: System.out.println("������������ ������!");
			}
		}
	}
}
