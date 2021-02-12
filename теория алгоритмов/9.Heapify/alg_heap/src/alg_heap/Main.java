package alg_heap;


public class Main {
	public static void main(String[] args) {
		double Bigarr[]=new double[100];
		for (int i = 0; i < Bigarr.length; i++) {
			Bigarr[i]=i;
		}
		double arr[]=new double[10];
		for (int i = 0; i < arr.length; i++) {
			int pos;
			do {
				pos=(int)(Math.random()*98+1);
			}while(Bigarr[pos]<0);
			arr[i]=Bigarr[pos];
			Bigarr[pos]=-1;
		}
		
		for (int i = 0; i < arr.length; i++) 
			System.out.print(arr[i]+" ");
		System.out.println();
		arr=piramidSort(arr);
		for (int i = 0; i < arr.length; i++) 
			System.out.print(arr[i]+" ");
		System.out.println();
		/*
		PriorityQueue h=new PriorityQueue(arr);
		h.printAsTree();
		h.print();
			//тест слияний приоритетных очередей
		PriorityQueue h2=new PriorityQueue();
		h2.insert(100);
		h2.insert(110);
		h2.insert(90);
		h.mergePriorQueues(h2);
		h.printAsTree();
		h.print();*/
		
	}
	public static double[] piramidSort(double[] arr) {
		Heap h=new Heap(arr);
		return h.toArray();
	}
}
