import java.util.*;
public class Ind1_3class {
	public static void main(String ags[]) {
		Scanner scan=new Scanner(System.in);
		int n; int[] arr;
		System.out.print("������� ���������� ���������: ");
		n=scan.nextInt();
		arr=new int[n];
		System.out.print("������� ���� ������������������: ");
		for(int i=0; i<n; ++i)
			arr[i]=scan.nextInt();
		System.out.print("������������������ ������������� �����: ");
		for(int i=0; i<n; ++i)
			System.out.print(per(arr[i])+" ");
	
		scan.close();
	}
	public static int per(int x) {	//�����������)0 �����
		int tmp=0,roz;
		for(roz=0; (x/(int)Math.pow(10, roz))!=0; ++roz){}
		for(int i=0; i<roz; i++) {
			tmp+=(x/Math.pow(10, i))%10;
			tmp*=10;
		}
		return tmp/10;
		
	}
}