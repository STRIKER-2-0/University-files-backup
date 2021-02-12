package algoritms_structs;

import java.util.EmptyStackException;

public class Stack extends Struct{
	public Stack(){			//конструктор по умолчанию
		super();
	}	
	
	public void push(Object elem) { 		//добавить элемент в конец
		arr[count]=elem;
		count++;
		if(count+1==arr.length)increase(10);		//если приблизились к границе,увеличить массив
	}
	public Object pop() {				//взять из конца
		if(count>0) {
			count--;
			return arr[count];
		}
		else throw new EmptyStackException();	//исключение в случае пустого стека
	}
	public Object top() {			//показать верх без удаления
		if(count>0) {
			return arr[count-1];
		}
		else throw new EmptyStackException();
	}
}
