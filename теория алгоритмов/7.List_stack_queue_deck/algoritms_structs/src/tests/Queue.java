package tests;

import java.util.EmptyStackException;

public class Queue {
	protected Object arr[];		//внутренний массив
	protected int count;		//кол-во элментов в нем
	
	
	public Queue(){			//конструктор по умолчанию
		arr=new Object[10];
		count=0;
	}	
	
	public void enQueue(Object elem) { 		//добавить элемент в конец
		arr[count]=elem;
		count++;
		if(count+1==arr.length)increase(10);		//если приблизились к границе,увеличить массив
	}
	public Object deQueue() {				//взять из начала
		if(count>0) {			
			Object val=arr[0];
			for (int i = 0; i < count; i++) {	//сдвиг элементов
				arr[i]=arr[i+1];
			}
			count--;
			return val;
		}
		else throw new EmptyStackException();
	}
	public Object front() {			//показать первый без удаления
		if(count>0) {
			return arr[0];
		}
		else throw new EmptyStackException();
	}
	
	private void increase(int num_elem) {			//увеличение 
		Object tmp[]=arr;
		arr=new Object[arr.length+num_elem];		
		for (int i = 0; i < tmp.length; i++) 
			arr[i]=tmp[i];					
	}
	protected void print() {
	//int tmp=arr.length;
	int tmp=count;
	for (int i = 0; i < tmp; i++) {
		System.out.print(arr[i]+" ");
	}
	System.out.println();	
	}
}
