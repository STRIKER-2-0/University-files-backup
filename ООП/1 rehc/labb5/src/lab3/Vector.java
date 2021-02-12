package lab3;


public class Vector {
	protected double[] arr;  
	protected int size=0;
	 
	public Vector(){ //конструктор по умолчанию
		arr=new double[10];
	}
	 
	public Vector(int capacity){ //конструктор с размером
		if(capacity>0)
			arr=new double[capacity];
		else
			System.out.println("Ошибка создания объекта! Размер массива должен быть больше нуля!");
	}
	 
	public Vector(double[] arr){ //конструктор через массив
		size=arr.length;
		this.arr=new double[size+10];  
		for(int i=0; i<size; i++)
			this.arr[i]=arr[i]; 
	}
	 
	private void increase(){ //приватный вспомогательный метод для увеличения массива 
		double[] tmp=new double[arr.length+10];
		for(int i=0; i<arr.length; i++)
			tmp[i]=arr[i];
		arr=tmp;
	}
	 
	public int getSize(){ //получить текущий размер
		return size;
	}
	public double get(int pos) { //получить значение из ячейки
		if((pos<size)&&(pos>=0)) 
			return arr[pos];
		else return 0;	
	}
	public void set(double val, int pos){ //замещение элемента
		if((pos<size)&&(pos>=0)) { //позиция должна быть строго меньше размера но не меньше нуля
			arr[pos]=val;
		}
		else System.out.println("Ошибка ввода! Неверные данные или элементы отсутствуют!");
	}
	public void insert(double val, int pos){  //добавление элемента
		if((pos<=size)&&(pos>=0)){  //позиция должна быть не больше размера и не меньше нуля
			for(int i=arr.length-1; i>pos; i--)  //сдвиг элементов
				arr[i]=arr[i-1];      
			arr[pos]=val;  
			size++;
			//System.out.println("Значение добавлено!");
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
	public Vector Clone() {  //создает клон объекта
		Vector tmp=new Vector();
		for(int i=0; i<size; i++)
			tmp.insert(arr[i], i);
		return tmp;
	}
	public void print(){  //метод печати
		if(size==0)
			System.out.println("Массив пуст!");
		else {
			for(int i=0; i<size/*arr.length*/; i++)
				System.out.print(arr[i]+" ");		
			System.out.println();
		}
	}
}