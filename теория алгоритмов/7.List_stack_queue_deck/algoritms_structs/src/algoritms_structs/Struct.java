package algoritms_structs;

public abstract class Struct {
	protected Object arr[];		//���������� ������
	protected int count;		//���-�� �������� � ���
	
	protected Struct() {
		arr=new Object[10];
		count=0;
	}
	protected void increase(int num_elem) {			//���������� 
		Object tmp[]=arr;
		arr=new Object[arr.length+num_elem];		
		for (int i = 0; i < tmp.length; i++) 
			arr[i]=tmp[i];					
	}
	public void print() {
		//int tmp=arr.length;
		int tmp=count;
		for (int i = 0; i < tmp; i++) {
			System.out.print(arr[i]+" ");
		}
			System.out.println();
	}
}
