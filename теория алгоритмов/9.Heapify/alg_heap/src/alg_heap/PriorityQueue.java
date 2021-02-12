package alg_heap;

public class PriorityQueue extends Heap{
	
	PriorityQueue(){
		super();
	}
	PriorityQueue(double arr[]){
		super(arr);
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
		while(true) {
			try {
				insert(h.max());
				h.extractMax();
			}catch(ArrayIndexOutOfBoundsException e) {
				break;
			}
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
}
