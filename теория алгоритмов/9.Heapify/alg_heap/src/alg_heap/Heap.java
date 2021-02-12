package alg_heap;

public class Heap{
	protected double[] arr;	//���������� ������ ����
	protected int size=0;		//���-�� ���������
	
	Heap(){			//������ ����
		arr=new double[10];
	}
	Heap(double arr[]) {	//���� �� ������� 
		this.arr=new double[arr.length];
		for (int i = 0; i < arr.length; i++) {
			this.arr[i]=arr[i];
			size++;
		}
		increase(5);
		for (int i = size/2; i>=0; i--)
			heapify(i);		
	}
	public void insert(double data) {	//���������� ��������
		int i=size;		
		arr[i]=data;
		if(i!=0) {	
			while(arr[i]>arr[(i-1)/2]) {	//����������� ����
				double tmp=arr[i];
				arr[i]=arr[(i-1)/2];
				arr[(i-1)/2]=tmp;
				i=(i-1)/2;
			}
		}
		size++;
		if(size==arr.length)increase(10);	//��������� ���� �����
	}
	public double max() throws ArrayIndexOutOfBoundsException{		//������� ��������
		if(size>0)
			return arr[0];
		else throw new ArrayIndexOutOfBoundsException();
	}
	public void extractMax(){		//������� ��������
		if(size>0) {
			int i=0;		
			arr[i]=arr[size-1];
			arr[size-1]=0;
			size--;
			heapify(i);
		}
	}
	public void heapify(int i) {	//�������������� ����
		int left=2*i+1, right=2*i+2, current=i;
		if(left<=size&&arr[left]>arr[current])	//���� ����� ������, ������ ��� �������
			current=left;
		if(right<=size&&arr[right]>arr[current])	//���� ������ ������ ��������(������� ����� ���� �����), ������ ��� �������
			current=right;
		if(current!=i) {	//���� ������� ���������, ������ ������� � �����������
			double tmp=arr[i];
			arr[i]=arr[current];
			arr[current]=tmp;
			heapify(current);	//��������� ��������� �� ���
		}
	}
	public void increaseKey(double key, double new_key) {			//��������� ��������� �����
		if(new_key<=key)return;
		for (int i = 0; i < size; i++) {
			if(arr[i]==key) {
				arr[i]=new_key;
				heapify((i-1)/2);
			}
		}
	}
	public void mergePriorQueues(Heap h) {		//������� ���
		while(h.getSize()!=0) {
			insert(h.max());
			h.extractMax();			
		}
	}
	public void delete(double key) {		//�������� �����
		for (int i = 0; i < size; i++) {
			if(arr[i]==key) {
				arr[i]=arr[size-1];
				arr[size-1]=0;
				size--;
				heapify(i);
				break;
			}
		}
	}
	public double[] toArray() {			//������� ��� ������
		double arr[]=new double[size];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=max();
			extractMax();
		}
		return arr;
	}
	public int getSize() {		//�������� ������
		return size;
	}
	
	
	public void print() {		//������ ���� ��� �������
		for (double elem : arr) 
			System.out.print((int)elem+" ");
		System.out.println();	
	}
	public void printAsTree() {		//������ ���� ��� ������
		int enter=size;		//������� ������� ������
		int tabs=0;			//���-�� ��������� ��� ������
		while(enter!=0) {		//������� � �����, ������� ��������� ����������� ��� �������� ������
			tabs=2*tabs+1;
			enter=(enter-1)/2;		
		}
		print_symbol(tabs);			//������� - ������ ���������
		for (int i = 0; i < size; i++) {
			System.out.print((int)arr[i]);		//����� - �������
			print_symbol(tabs*2+1);		//�����  ���������� - � ��� ���� ������ ���������
			if(i==enter) {					//� ������, ���� ����� �� ����� ������ 
				System.out.println(); 		//��������� ������
				tabs=(tabs-1)/2; 			//�������� ���-�� ���������
				enter=enter*2+2;			//��������� ����� �������� ��������
				print_symbol(tabs);		//������ �������� ��� ������ ������
			}
		}
		System.out.println();
	}
	protected void print_symbol(int n) {		//������ ��������� 
		for(int i=0; i<n; i++)
			System.out.print(" ");
	}
	protected void increase(int num_elem) {			//���������� 
		double tmp[]=arr;
		arr=new double[arr.length+num_elem];		
		for (int i = 0; i < tmp.length; i++) 
			arr[i]=tmp[i];					
	}
}