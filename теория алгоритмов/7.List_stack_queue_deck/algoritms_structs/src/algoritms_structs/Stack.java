package algoritms_structs;

import java.util.EmptyStackException;

public class Stack extends Struct{
	public Stack(){			//����������� �� ���������
		super();
	}	
	
	public void push(Object elem) { 		//�������� ������� � �����
		arr[count]=elem;
		count++;
		if(count+1==arr.length)increase(10);		//���� ������������ � �������,��������� ������
	}
	public Object pop() {				//����� �� �����
		if(count>0) {
			count--;
			return arr[count];
		}
		else throw new EmptyStackException();	//���������� � ������ ������� �����
	}
	public Object top() {			//�������� ���� ��� ��������
		if(count>0) {
			return arr[count-1];
		}
		else throw new EmptyStackException();
	}
}
