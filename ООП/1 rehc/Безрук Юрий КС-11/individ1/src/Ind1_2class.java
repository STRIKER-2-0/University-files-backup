import java.util.*;
public class Ind1_2class {	
	public static void main(String ags[]) {
		Scanner scan=new Scanner(System.in);
		int N;
		int[] arr;
		System.out.print("������� ������ �������: ");
		N=scan.nextInt();
		arr=new int[N];
		for(int i=0; i<arr.length; i++)
			arr[i]=(int)(20*Math.random())-10;
		
		Print(arr);
		pros_ads(arr);
		bouble(arr);
		scan.close();	//�������� �������
		
	}
	public static void Print(int[] arr) {	//������ �������
		System.out.println("������:");
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i]+" ");
	}
	public static void pros_ads(int[] arr) {	//������������ ����� ��� � ���� �� ������ ����������
		int min=10,minNum=0,max=0,maxNum=0,result=1;
		boolean flag=false;
		for(int i=0; i<arr.length; i++) {
			if(Math.abs(arr[i])<min) {
				min=Math.abs(arr[i]);
				minNum=i;
			}
			if(Math.abs(arr[i])>max) {
				max=Math.abs(arr[i]);
				maxNum=i;
			}
		}
		if(minNum<maxNum)flag=true;
		if(flag==true)
			for(int i=minNum+1; i<maxNum; i++)
				result*=arr[i];
		else
			for(int i=maxNum+1; i<minNum; i++)
				result*=arr[i];
		
		System.out.println("\n���������� � ���������� �� ������ ��������: "+min+" � "+max);
		System.out.print("����������� ���������, ������� ����� ����: ");
		
		if((minNum==maxNum-1)||(minNum==maxNum+1))		//�������� �� ����������� ��������� ����� ��� � ����
			System.out.println("����� ��������� � ���������� ��� ���������");
		else
			System.out.println(result);		
			
	}
	public static void bouble(int[] arr) { //���������� ���������
    	int tmp;    	
    	for(int j=0; j<arr.length-1; j++)
	    	for(int i=0; i<arr.length-1; i++) 
	    		if(arr[i]>arr[i+1]) {
		    		tmp=arr[i+1];
		    		arr[i+1]=arr[i];
		    		arr[i]=tmp;
		    	}	    	
    	System.out.print("��������������� �� ����������� ");
    	Print(arr);    		    		    			
    }
	
}
