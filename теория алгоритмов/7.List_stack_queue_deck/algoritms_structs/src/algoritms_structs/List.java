package algoritms_structs;

public class List extends Struct{
	public int current;		//текущий элемент, для next и prev
	
	public List(){			//конструктор по умолчанию
		super();
		current=0;
	}
	public List(Object[] arr) {		//список из массива
		this.arr=new Object[arr.length+10];
		for (int i = 0; i < arr.length; i++) {
			this.arr[i]=arr[i];
		}
		count=arr.length;
		current=0;
	}
	
	
	public void insert(Object elem) { 		//добавить элемент в конец
		arr[count]=elem;
		count++;
		if(count+1==arr.length)increase(10);		//если приблизились к границе,увеличить массив
	}
	public void insert(Object elem, int position) {		//вставить в середину списка
			for (int i = count+1; i > position; i--) {
				arr[i]=arr[i-1];
			}
			arr[position]=elem;
			count++;
			
		if(count+1==arr.length)increase(10);
	}	
	public void delete(int position) {		//удаление элемента по позиции
		if((position<count)&&(position>=0)&&(count>0)) {
			for (int i = position+1; i < arr.length; i++) {
				arr[i-1]=arr[i];
			}
			count--;
		}
	}	
	public int lookUp(Object elem) {		//поиск элемента по значению
		for (int i = 0; i < count; i++) {
			if(arr[i]==elem)
				return i;
		}
		new IllegalArgumentException().printStackTrace();
		return -1;				//ошибка для выхода из метода в случае отсутствия необходимого элемента
		
	}	
	public Object get(int pos) {
		return arr[pos];
	}
	public void set(int elem, int pos) {
		arr[pos]=elem;
	}	
	public Object next() {						//следующий
		//if(current<count) {
			Object elem=arr[current];
			current++;
			if(current==count)current--;		//что бы не выйти за грани
			return elem;
		/*}
		else { 
			current--;
			throw new ArrayIndexOutOfBoundsException(current+1);
			
		}*/
	}
	public Object prev() {			//предыдущий
		//if(current>=0) {
			Object elem=arr[current];
			current--;
			if(current==-1)current++;		//--||-- next
			return elem;
		//}
		//else throw new ArrayIndexOutOfBoundsException(current);
	}	
}