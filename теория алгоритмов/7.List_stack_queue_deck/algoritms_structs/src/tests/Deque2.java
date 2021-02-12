package tests;

import java.util.EmptyStackException;

public class Deque2 extends Queue{
	
	Deque2(){
		super();
	}
	
	public void pushFront(Object elem) {		//добавить элемент в начало
		for (int i = count; i>0; i--) {
			arr[i]=arr[i-1];
		}
		arr[0]=elem;
		count++;
	}
	public Object popBack() {			//взять из конца
		if(count>0) {
			count--;
			return arr[count];
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
