import java.util.*;

public class Lab1class {
	public static int typech=0,q=0;    
	public static void main(String ags[]){
	    	Scanner scn=new Scanner(System.in);
	    	int N,M;
	    	System.out.print("������� ������� �������: ");
	    	N=scn.nextInt();
	    	M=scn.nextInt();
	    	q=scn.nextInt();
	    	int[][] arr=new int[N][M];
	    	int[][] reserv=new int[N][M];
	    	create(arr);
	    	for(int i=0; i<arr.length; i++) 
	    		for(int j=0; j<arr[i].length; j++)
	    			reserv[i][j]=arr[i][j];
	    	for(;;) {
		    	print(arr);
		    	if(menu(scn, arr)==1)
		    		for(int i=0; i<arr.length; i++) 
			    		for(int j=0; j<arr[i].length; j++)
			    			arr[i][j]=reserv[i][j];
		    	else break;
	    	}
	    	System.out.print("�������� ���!!!");
	        	
	    }
	public static void create(int[][] mas) { //���������� ������� ��������
	    	for(int i=0; i<mas.length; i++) 
	    		for(int j=0; j<mas[i].length; j++)
	    			mas[i][j]=(int)(10*Math.random());
	    		
	    }
	public static void print(int[][] mas) { //������
	   	for(int i=0; i<mas.length; i++) {
	   		for(int j=0; j<mas[i].length; j++)
	    		System.out.print(mas[i][j]+" ");
	    System.out.println();}
	    }
	public static int menu(Scanner scan, int[][] arr) { //����
	    	int ans;
	    	System.out.println("�������� ��� ����������: \n1.���������� ���������\n2.���������� ������������ ���������\n3.���������� �����, ������� q");
	    	ans=scan.nextInt();
	    	switch(ans) {
	    		case 1: bouble(arr,scan); break;
	    		case 2: break;
	    		case 3: break;
	    		default: System.out.println("������������ ��������! ���������� �����. "); menu(scan, arr);
	    	}
	    	System.out.println("�������� ���� ���������� ��������:\n1.����� ����������\n2.�����");
	    	
	    	ans=scan.nextInt();
	    	while((ans!=1)&&(ans!=2)) {
	    		System.out.println("������������ ��������! ���������� �����. ");
	    		ans=scan.nextInt();
	    	}
	    	
	    	switch(ans) {
	    		case 1: return 1;
	    		case 2: return 2;
	    		default: return 0;
	    	}
	    }	     	
	public static void bouble(int[][] arr, Scanner scan) { //���������� ���������
	    	int tmp[];int ans;
	    	System.out.println("�������� ��������������: \n1.������� ��������������\n2.���������� �����, ������� q");
	    	ans=scan.nextInt();
	    	for(int j=0; j<arr.length-1; j++)
		    	for(int i=0; i<arr.length-1; i++) 
		    		if(chrt(arr[i],ans)>chrt(arr[i+1],ans)) {
			    			tmp=arr[i+1];
			    			arr[i+1]=arr[i];
			    			arr[i]=tmp;
			    			}	    	
	    	System.out.println("������ � ���������������� ��������:");
	    	print(arr);	    		    			
	    }
	public static double chrt(int[] line, int x) { //����� ��������������
	    	
	    	switch(x) {
	    		case 1: return srd(line);
	    		case 2: return numq(line);
	    		default: return 0;
	    	}
	    }
	public static double srd(int[] tmparr) { //������� �������������� ������
	    	double result=0;
	    	for(int i=0; i<tmparr.length; i++) 
	    		result+=tmparr[i];
	    	typech=1;
	    	return result/tmparr.length;
	    }
	public static int numq(int[] tmparr) {		 
		 int result=0;
		 for(int i=0; i<tmparr.length; i++) 
	    		if((tmparr[i]%q)==0)
	    			++result;
		 return result;
		 }
}


