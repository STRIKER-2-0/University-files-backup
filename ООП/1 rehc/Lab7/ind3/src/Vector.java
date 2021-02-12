
class Vector {
	protected Barber[] arr;  
	protected int size=0;
	 
	public Vector(){ //����������� �� ���������
		arr=new Barber[10];
	}
	 
	public Vector(int capacity){ //����������� � ��������
		if(capacity>0)
			arr=new Barber[capacity];
		else
			System.out.println("������ �������� �������! ������ ������� ������ ���� ������ ����!");
	}
	 
	private void increase(){ //��������� ��������������� ����� ��� ���������� ������� 
		Barber[] tmp=new Barber[arr.length+10];
		for(int i=0; i<arr.length; i++)
			tmp[i]=arr[i];
		arr=tmp;
	}
	 
	public int getSize(){ //�������� ������� ������
		return size;
	}
	public Barber get(int pos) { //�������� �������� �� ������
		if((pos<size)&&(pos>=0)) 
			return arr[pos];
		else return arr[0];	
	}
	public void set(Barber val, int pos){ //��������� ��������
		if((pos<size)&&(pos>=0)) { //������� ������ ���� ������ ������ ������� �� �� ������ ����
			arr[pos]=val;
		}
		else System.out.println("������ �����! �������� ������ ��� �������� �����������!");
	}
	public void insert(Barber val, int pos){  //���������� ��������
		if((pos<=size)&&(pos>=0)){  //������� ������ ���� �� ������ ������� � �� ������ ����
			for(int i=arr.length-1; i>pos; i--)  //����� ���������
				arr[i]=arr[i-1];      
			arr[pos]=val;  
			size++;
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
	public void print(){  //����� ������
		if(size==0)
			System.out.println("������ ����!");
		else {
			for(int i=0; i<size/*arr.length*/; i++)
				arr[i].info();
			System.out.println();
		}
	}
}