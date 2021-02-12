
class Vector {
	protected Barber[] arr;  
	protected int size=0;
	 
	public Vector(){ //конструктор по умолчанию
		arr=new Barber[10];
	}
	 
	public Vector(int capacity){ //конструктор с размером
		if(capacity>0)
			arr=new Barber[capacity];
		else
			System.out.println("Ошибка создания объекта! Размер массива должен быть больше нуля!");
	}
	 
	private void increase(){ //приватный вспомогательный метод для увеличения массива 
		Barber[] tmp=new Barber[arr.length+10];
		for(int i=0; i<arr.length; i++)
			tmp[i]=arr[i];
		arr=tmp;
	}
	 
	public int getSize(){ //получить текущий размер
		return size;
	}
	public Barber get(int pos) { //получить значение из ячейки
		if((pos<size)&&(pos>=0)) 
			return arr[pos];
		else return arr[0];	
	}
	public void set(Barber val, int pos){ //замещение элемента
		if((pos<size)&&(pos>=0)) { //позиция должна быть строго меньше размера но не меньше нуля
			arr[pos]=val;
		}
		else System.out.println("Ошибка ввода! Неверные данные или элементы отсутствуют!");
	}
	public void insert(Barber val, int pos){  //добавление элемента
		if((pos<=size)&&(pos>=0)){  //позиция должна быть не больше размера и не меньше нуля
			for(int i=arr.length-1; i>pos; i--)  //сдвиг элементов
				arr[i]=arr[i-1];      
			arr[pos]=val;  
			size++;
			if(size==arr.length) //увеличение размера по надобности
				increase();
		}
		else System.out.println("Ошибка ввода! Неверные данные!");
	  
	}
	public void erase(int pos) { //удаление элемента со сдвигом
		if((pos<size)&&(pos>=0)){  
			for(int i=pos; i<size-1; i++)  //перезапись элементов
				arr[i]=arr[i+1];    
			size--; 
	   
		}
		else System.out.println("Ошибка ввода! Неверные данные!");
	  
	}
	public void clear() { //очистка. Просто делаем размер нулевым, и данные буду перезаписывается незаметно для пользоавтеля
		size=0;
	}
	public void print(){  //метод печати
		if(size==0)
			System.out.println("Массив пуст!");
		else {
			for(int i=0; i<size/*arr.length*/; i++)
				arr[i].info();
			System.out.println();
		}
	}
}