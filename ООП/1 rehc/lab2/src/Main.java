import java.util.*;
public class Main {
	public static void main(String ags[]) {		
		Scanner scan=new Scanner(System.in);
		float value;
		Stakan stak=new Stakan();
		System.out.print("������ ������ � �������� �����������:\n�������� ������������ �������:\n1.�������� ���������� � ������� ������� get:\n");
		System.out.println("�����: "+stak.getMass()+"g");
		System.out.println("�����: "+stak.getVolume()+"ml");
		System.out.println("����������: "+stak.getContent()+"ml");
		System.out.println("��������� ����� ���������� � ������� ������� set:");
		
		do{
			System.out.println("������� �����: ");
			value=scan.nextFloat();
			if(stak.setMass(value))
				System.out.println("����� �����������");
			else
				System.out.println("������ ���������");
		}while(!stak.setMass(value));
		
		do{
			System.out.println("������� �����: ");
			value=scan.nextFloat();
			if(stak.setVolume(value))
				System.out.println("����� ����������");
			else
				System.out.println("������ ���������");
		}while(!stak.setVolume(value));
		
		do{
			System.out.println("������� ����������: ");
			value=scan.nextFloat();
			if(stak.setContent(value))
				System.out.println("���������� �����������");
			else
				System.out.println("������ ���������");
		}while(!stak.setContent(value));
					
		System.out.println("������ ���� ������ � ������� ������ print: ");
		stak.print();
		
		stak=new Stakan(30,6);
		System.out.print("������ ������ � ��������������� �����������:\n");
		stak.print();
		
	}
}
