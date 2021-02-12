package alg_heap;

public class Heap{
	protected double[] arr;	//внутренний массив кучи
	protected int size=0;		//кол-во элементов
	
	Heap(){			//пустая куча
		arr=new double[10];
	}
	Heap(double arr[]) {	//куча из массива 
		this.arr=new double[arr.length];
		for (int i = 0; i < arr.length; i++) {
			this.arr[i]=arr[i];
			size++;
		}
		increase(5);
		for (int i = size/2; i>=0; i--)
			heapify(i);		
	}
	public void insert(double data) {	//добавление элемента
		int i=size;		
		arr[i]=data;
		if(i!=0) {	
			while(arr[i]>arr[(i-1)/2]) {	//перестройка кучи
				double tmp=arr[i];
				arr[i]=arr[(i-1)/2];
				arr[(i-1)/2]=tmp;
				i=(i-1)/2;
			}
		}
		size++;
		if(size==arr.length)increase(10);	//увеличить если нужно
	}
	public double max() throws ArrayIndexOutOfBoundsException{		//вернуть максимум
		if(size>0)
			return arr[0];
		else throw new ArrayIndexOutOfBoundsException();
	}
	public void extractMax(){		//удалить максимум
		if(size>0) {
			int i=0;		
			arr[i]=arr[size-1];
			arr[size-1]=0;
			size--;
			heapify(i);
		}
	}
	public void heapify(int i) {	//восстановление кучи
		int left=2*i+1, right=2*i+2, current=i;
		if(left<=size&&arr[left]>arr[current])	//если левый больше, делаем его текущим
			current=left;
		if(right<=size&&arr[right]>arr[current])	//если правый больше текущего(который может быть левым), делать его текущим
			current=right;
		if(current!=i) {	//если текущий изменился, меняем местами с изначальным
			double tmp=arr[i];
			arr[i]=arr[current];
			arr[current]=tmp;
			heapify(current);	//запускаем процедуру на нем
		}
	}
	public void increaseKey(double key, double new_key) {			//увеличить приоритет ключа
		if(new_key<=key)return;
		for (int i = 0; i < size; i++) {
			if(arr[i]==key) {
				arr[i]=new_key;
				heapify((i-1)/2);
			}
		}
	}
	public void mergePriorQueues(Heap h) {		//слияние куч
		while(h.getSize()!=0) {
			insert(h.max());
			h.extractMax();			
		}
	}
	public void delete(double key) {		//удаление ключа
		for (int i = 0; i < size; i++) {
			if(arr[i]==key) {
				arr[i]=arr[size-1];
				arr[size-1]=0;
				size--;
				heapify(i);
				break;
			}
		}
	}
	public double[] toArray() {			//вернуть как массив
		double arr[]=new double[size];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=max();
			extractMax();
		}
		return arr;
	}
	public int getSize() {		//получить размер
		return size;
	}
	
	
	public void print() {		//печать кучи как массива
		for (double elem : arr) 
			System.out.print((int)elem+" ");
		System.out.println();	
	}
	public void printAsTree() {		//печать кучи как дерева
		int enter=size;		//крайний элемент уровня
		int tabs=0;			//кол-во табуляций для уровня
		while(enter!=0) {		//считаем с конца, сколько табуляций понадобится для верхнего уровня
			tabs=2*tabs+1;
			enter=(enter-1)/2;		
		}
		print_symbol(tabs);			//вначале - первые табуляции
		for (int i = 0; i < size; i++) {
			System.out.print((int)arr[i]);		//затем - элемент
			print_symbol(tabs*2+1);		//между  элементами - в два раза больше табуляций
			if(i==enter) {					//в случае, если дошли до конца уровня 
				System.out.println(); 		//переводим строку
				tabs=(tabs-1)/2; 			//пересчет кол-ва табуляций
				enter=enter*2+2;			//перестчет ключа крайнего элемента
				print_symbol(tabs);		//печать отступов для нового уровня
			}
		}
		System.out.println();
	}
	protected void print_symbol(int n) {		//печать табуляций 
		for(int i=0; i<n; i++)
			System.out.print(" ");
	}
	protected void increase(int num_elem) {			//увеличение 
		double tmp[]=arr;
		arr=new double[arr.length+num_elem];		
		for (int i = 0; i < tmp.length; i++) 
			arr[i]=tmp[i];					
	}
}