package algoritms_structs;

public class List extends Struct{
	public int current;		//������� �������, ��� next � prev
	
	public List(){			//����������� �� ���������
		super();
		current=0;
	}
	public List(Object[] arr) {		//������ �� �������
		this.arr=new Object[arr.length+10];
		for (int i = 0; i < arr.length; i++) {
			this.arr[i]=arr[i];
		}
		count=arr.length;
		current=0;
	}
	
	
	public void insert(Object elem) { 		//�������� ������� � �����
		arr[count]=elem;
		count++;
		if(count+1==arr.length)increase(10);		//���� ������������ � �������,��������� ������
	}
	public void insert(Object elem, int position) {		//�������� � �������� ������
			for (int i = count+1; i > position; i--) {
				arr[i]=arr[i-1];
			}
			arr[position]=elem;
			count++;
			
		if(count+1==arr.length)increase(10);
	}	
	public void delete(int position) {		//�������� �������� �� �������
		if((position<count)&&(position>=0)&&(count>0)) {
			for (int i = position+1; i < arr.length; i++) {
				arr[i-1]=arr[i];
			}
			count--;
		}
	}	
	public int lookUp(Object elem) {		//����� �������� �� ��������
		for (int i = 0; i < count; i++) {
			if(arr[i]==elem)
				return i;
		}
		new IllegalArgumentException().printStackTrace();
		return -1;				//������ ��� ������ �� ������ � ������ ���������� ������������ ��������
		
	}	
	public Object get(int pos) {
		return arr[pos];
	}
	public void set(int elem, int pos) {
		arr[pos]=elem;
	}	
	public Object next() {						//���������
		//if(current<count) {
			Object elem=arr[current];
			current++;
			if(current==count)current--;		//��� �� �� ����� �� �����
			return elem;
		/*}
		else { 
			current--;
			throw new ArrayIndexOutOfBoundsException(current+1);
			
		}*/
	}
	public Object prev() {			//����������
		//if(current>=0) {
			Object elem=arr[current];
			current--;
			if(current==-1)current++;		//--||-- next
			return elem;
		//}
		//else throw new ArrayIndexOutOfBoundsException(current);
	}	
}