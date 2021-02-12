//��������� �� ������������� ��� ������������. ��� ���� ������ Main � ����� ������� Stakan
import java.util.*;

public class Main {
	public static void main(String ags[]) {		
		Scanner scan=new Scanner(System.in);
		float value;	//�������� ��� ����������
		Stakan stak=new Stakan();	//���� - ������� ������(������ �����������)
		//���� ������� get
		System.out.print("������ ������ � �������� �����������:\n�������� ������������ �������:\n�������� ���������� � ������� ������� get:\n");
		System.out.println("�����: "+stak.getMass()+"g");
		System.out.println("�����: "+stak.getVolume()+"ml");
		System.out.println("����������: "+stak.getContent()+"ml");
		System.out.println("��������� ����� ���������� � ������� ������� set:");
		//���� ������� set
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
		
		//���� �����a print
		System.out.println("������ ���� ������ � ������� ������ print: ");
		stak.print();
		//������ � �����������(������ �������� �� ��������, ������ �����)
		stak=new Stakan(30,-6);
		System.out.print("\n������ ������ � ��������������� �����������:\n");
		stak.print();		
		
		//������ ��������
		Stakan[] stakans;
		stakans=new Stakan[5];
		for(int i=0; i<stakans.length; i++)
			stakans[i]=new Stakan();
		System.out.print("\n������ ��������:\n");
		for(int i=0; i<stakans.length; i++)
			stakans[i].print();
		
		//����� �������� - ������� ����
		int ans=1;
		while(ans!=0) {	
			System.out.println("\n����������� ��������� ������ �������� �������: ������� ����� ��������:");
			int num=scan.nextInt();
			while((num<0)||(num>4)) {//�������� �� ������������ ������
				System.out.println("�������������� �������!!");
				num=scan.nextInt();
			}
			
			//��� ����������� ���� ��� �������� ���������� ����������
			System.out.println("\n�������� � ��������:\n1.�������� ��������������(get)\n2.���������� ��������������(set)\n3.�������� ������� ��������������(print)\n0.��������� ����");
			ans=scan.nextInt();
			switch(ans) {
			case 1: getch(stakans,num,scan); break;	//��� ����, ��� �� �� ����������� ���� ������� ����������, ������� ��������� �������
			case 2: setch(stakans,num,scan);break;
			case 3: stakans[num].print(); break;
			case 0: scan.close(); System.out.print("---����� �����---"); return; //���� ��� �� ����������
			default: System.out.print("������������ ��������!!\n");
			}
		}
		scan.close();
	}
	//������� ��� get-��
	public static void getch(Stakan[] stakans, int num, Scanner scan) {
		System.out.println("\n�������� � ��������:\n1.�������� �����\n2.�������� �����\n3.�������� ����������\n0.��������� � ���������� ����");
		int ans=scan.nextInt();
		switch(ans) {
		case 1: System.out.println("�����: "+stakans[num].getMass()); break;
		case 2: System.out.println("�����: "+stakans[num].getVolume()); break;
		case 3: System.out.println("����������: "+stakans[num].getContent()); break;
		case 0: return;
		default: System.out.print("������������ ��������!!\n");
		}
	}
	//������� ��� set-��
	public static void setch(Stakan[] stakans, int num, Scanner scan) {
		System.out.println("\n�������� � ��������:\n1.���������� �����\n2.���������� �����\n3.���������� ����������\n0.��������� � ���������� ����");
		int ans=scan.nextInt();
		float value;
		switch(ans) {
		case 1: do{
			System.out.println("������� �����: ");
			value=scan.nextFloat();
			if(stakans[num].setMass(value))
				System.out.println("����� �����������");
			else
				System.out.println("������ ���������");
		}while(!stakans[num].setMass(value)); break;
		case 2: do{
			System.out.println("������� �����: ");
			value=scan.nextFloat();
			if(stakans[num].setVolume(value))
				System.out.println("����� �����������");
			else
				System.out.println("������ ���������");
		}while(!stakans[num].setVolume(value)); break;
		case 3: do{
			System.out.println("������� ����������: ");
			value=scan.nextFloat();
			if(stakans[num].setContent(value))
				System.out.println("���������� �����������");
			else
				System.out.println("������ ���������");
		}while(!stakans[num].setContent(value)); break;
		case 0: return;
		default: System.out.print("������������ ��������!!\n");
		}
	}
}