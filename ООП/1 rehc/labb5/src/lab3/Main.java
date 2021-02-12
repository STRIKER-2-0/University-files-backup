package lab3;
import java.util.*;
import java.lang.Thread;	//��� ���
public class Main {
	public static void main(String ags[])throws InterruptedException {	//��� ���
		Scanner scan=new Scanner(System.in);
		int ans,val;
		double[] arr=new double[5];
		for(int i=0; i< arr.length; i++)
			arr[i]=(int)(Math.random()*10);
		Vector vk=new Vector(arr);		
		
		System.out.println("������ vector ������! �������� ���������� ��������: ");
		while(true) {
			Thread.sleep(1500);	//��� ��� �������
			System.out.println("\n1.�������� ������� ������\n2.�������� �������� �� ������\n3.�������� �������\n4.�������� �������\n5.������� �������\n6.�������� ������\n7.����������� ������\n8.������� �����\n9.�����");
			ans=scan.nextInt();
			switch(ans) {
				case 1: System.out.println("������� ������: "+vk.getSize()); break;
				case 2: System.out.print("������� ����� ������: "); 
						ans=scan.nextInt();
						System.out.println("�������� � ������: "+vk.get(ans));
						break;
				case 3: System.out.print("������� ����� ������: "); 
						ans=scan.nextInt();
						System.out.print("������� ��������: "); 
						val=scan.nextInt();
						vk.set(val, ans);
						break;
				case 4: System.out.print("������� ����� ������: "); 
						ans=scan.nextInt();
						System.out.print("������� ��������: "); 
						val=scan.nextInt();
						vk.insert(val, ans);
						break;
				case 5: System.out.print("������� ����� ������: "); 
						ans=scan.nextInt();
						vk.erase(ans);
						break;
				case 6: vk.clear(); break;
				case 7: vk.print(); break;
				case 8: Vector b=vk.Clone(); System.out.println("���� ������!!"); Clone(scan,b); break;
				case 9: System.out.println("---����� �����---"); scan.close(); return;
				default: System.out.println("������������ ������!");
			}
		}		
		
	}
	public static void Clone(Scanner scan, Vector vk)throws InterruptedException {
		int ans,val;
		System.out.println("---������ � ������---");
		while(true) {
			Thread.sleep(1500);	//��� ��� �������
			System.out.println("\n1.�������� ������� ������\n2.�������� �������� �� ������\n3.�������� �������\n4.�������� �������\n5.������� �������\n6.�������� ������\n7.����������� ������\n8.������� �����\n9.�����");
			ans=scan.nextInt();
			switch(ans) {
				case 1: System.out.println("������� ������: "+vk.getSize()); break;
				case 2: System.out.print("������� ����� ������: "); 
						ans=scan.nextInt();
						System.out.println("�������� � ������: "+vk.get(ans));
						break;
				case 3: System.out.print("������� ����� ������: "); 
						ans=scan.nextInt();
						System.out.print("������� ��������: "); 
						val=scan.nextInt();
						vk.set(val, ans);
						break;
				case 4: System.out.print("������� ����� ������: "); 
						ans=scan.nextInt();
						System.out.print("������� ��������: "); 
						val=scan.nextInt();
						vk.insert(val, ans);
						break;
				case 5: System.out.print("������� ����� ������: "); 
						ans=scan.nextInt();
						vk.erase(ans);
						break;
				case 6: vk.clear(); break;
				case 7: vk.print(); break;
				case 8: Vector b=vk.Clone(); System.out.println("���� ������!!"); Clone(scan,b); break;
				case 9: System.out.println("---������� � ����������� �������---");  return;
				default: System.out.println("������������ ������!");
			}
		}
	}
}
