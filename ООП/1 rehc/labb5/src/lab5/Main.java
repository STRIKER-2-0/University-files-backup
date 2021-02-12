package lab5;
//import java.util.*;
import lab3.Vector;

public class Main{
	public static void main(String ags[]) {
		/*Scanner scan=new Scanner(System.in)*/
		
		Queue st=new Queue();
		for(int i=0; i<1; i++)
			st.enqueue(i+1);
		st.print();
		st.dequeue();
		st.dequeue();
		st.print();
		st.clear();
		st.print();
	}
}	

class Stack implements StackInt{
    private Vector vk;
   
    Stack(){
        vk=new Vector();
    }
    public void push(int val){
        vk.insert(val,0);
    }
    public double pop(){
        double get=vk.get(0);
        vk.erase(0);
        return get;
    }
    public int getSize() {
    	return vk.getSize();
    }
    public void clear(){
        vk.clear();
    }
    void print(){
        vk.print();
    }
}

class Queue implements QueueInt{
    private Vector vk;
   
    Queue(){
        vk=new Vector();
    }
    public void enqueue(int val){
        vk.insert(val,0);
    }
    public double dequeue(){
        double get=vk.get(vk.getSize()-1);
        vk.erase(vk.getSize()-1);
        return get;
    }
    public int getSize() {
    	return vk.getSize();
    }
    public void clear(){
        vk.clear();
    }
    void print(){
        vk.print();
    }
}