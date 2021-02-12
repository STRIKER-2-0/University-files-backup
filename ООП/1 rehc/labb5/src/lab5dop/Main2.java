package lab5dop;
import lab3.Vector;
import lab5.*;

public class Main2{
	public static void main(String ags[]) {
		/*Scanner scan=new Scanner(System.in)*/
		
		Queue st=new Queue();
		for(int i=0; i<10; i++)
			st.enqueue(i+1);
		st.print();
		st.dequeue();
		st.print();
		System.out.println(st.getSize());
		
		st.clear();
		st.print();
		
	}
}	

class Stack extends Vector implements StackInt{   
    Stack(){
        super();
    }
    public void push(int val){
        insert(val,0);
    }
    public double pop(){
        double get=arr[0];
        erase(0);
        return get;
    }
    
}
class Queue extends Vector implements QueueInt{   
    Queue(){
        super();
    }
    public void enqueue(int val){
        insert(val,0);
    }
    public double dequeue(){
        double get=arr[size-1];
        erase(size-1);
        return get;
    }
    
}