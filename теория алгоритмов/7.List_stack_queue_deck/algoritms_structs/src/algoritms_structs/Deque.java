package algoritms_structs;

import java.util.EmptyStackException;

public class Deque extends Struct{
	
	public Deque(){			//����������� �� ���������
		super();
	}	
	
	public void pushFront(Object elem) {		//�������� ������� � ������
		for (int i = count; i>0; i--) {
			arr[i]=arr[i-1];
		}
		arr[0]=elem;
		count++;
	}
	public void pushBack(Object elem) { 		//�������� ������� � �����
		arr[count]=elem;
		count++;
		if(count+1==arr.length)increase(10);		//���� ������������ � �������,��������� ������
	}
	public Object popFront() {		//����� �� ������
		if(count>0) {			
			Object val=arr[0];
			for (int i = 0; i < count; i++) {
				arr[i]=arr[i+1];
			}
			count--;
			return val;
		}
		else throw new EmptyStackException();
	}
	public Object popBack() {			//����� �� �����
		if(count>0) {
			count--;
			return arr[count];
		}
		else throw new EmptyStackException();
	}
	public Object front() {
		if(count>0) {
			return arr[0];
		}
		else throw new EmptyStackException();
	}
	public Object back() {
		if(count>0) {
			return arr[count-1];
		}
		else throw new EmptyStackException();
	}
}
