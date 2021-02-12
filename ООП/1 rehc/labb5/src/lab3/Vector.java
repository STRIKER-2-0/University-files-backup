package lab3;


public class Vector {
	protected double[] arr;  
	protected int size=0;
	 
	public Vector(){ //����������� �� ���������
		arr=new double[10];
	}
	 
	public Vector(int capacity){ //����������� � ��������
		if(capacity>0)
			arr=new double[capacity];
		else
			System.out.println("������ �������� �������! ������ ������� ������ ���� ������ ����!");
	}
	 
	public Vector(double[] arr){ //����������� ����� ������
		size=arr.length;
		this.arr=new double[size+10];  
		for(int i=0; i<size; i++)
			this.arr[i]=arr[i]; 
	}
	 
	private void increase(){ //��������� ��������������� ����� ��� ���������� ������� 
		double[] tmp=new double[arr.length+10];
		for(int i=0; i<arr.length; i++)
			tmp[i]=arr[i];
		arr=tmp;
	}
	 
	public int getSize(){ //�������� ������� ������
		return size;
	}
	public double get(int pos) { //�������� �������� �� ������
		if((pos<size)&&(pos>=0)) 
			return arr[pos];
		else return 0;	
	}
	public void set(double val, int pos){ //��������� ��������
		if((pos<size)&&(pos>=0)) { //������� ������ ���� ������ ������ ������� �� �� ������ ����
			arr[pos]=val;
		}
		else System.out.println("������ �����! �������� ������ ��� �������� �����������!");
	}
	public void insert(double val, int pos){  //���������� ��������
		if((pos<=size)&&(pos>=0)){  //������� ������ ���� �� ������ ������� � �� ������ ����
			for(int i=arr.length-1; i>pos; i--)  //����� ���������
				arr[i]=arr[i-1];      
			arr[pos]=val;  
			size++;
			//System.out.println("�������� ���������!");
			if(size==arr.length) //���������� ������� �� ����������
				increase();
		}
		else System.out.println("������ �����! �������� ������!");
	  
	}
	public void erase(int pos) { //�������� �������� �� �������
		if((pos<size)&&(pos>=0)){  
			for(int i=pos; i<size-1; i++)  //���������� ���������
				arr[i]=arr[i+1];    
			size--; 
	   
		}
		else System.out.println("������ �����! �������� ������!");
	  
	}
	public void clear() { //�������. ������ ������ ������ �������, � ������ ���� ���������������� ��������� ��� ������������
		size=0;
	}
	public Vector Clone() {  //������� ���� �������
		Vector tmp=new Vector();
		for(int i=0; i<size; i++)
			tmp.insert(arr[i], i);
		return tmp;
	}
	public void print(){  //����� ������
		if(size==0)
			System.out.println("������ ����!");
		else {
			for(int i=0; i<size/*arr.length*/; i++)
				System.out.print(arr[i]+" ");		
			System.out.println();
		}
	}
}