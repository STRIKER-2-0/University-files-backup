package algoritms_structs;

import java.util.EmptyStackException;

public class Queue extends Struct{	
	
	public Queue(){			//конструктор по умолчанию
		super();
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
}
