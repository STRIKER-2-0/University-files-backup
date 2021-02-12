package algoritms_structs;
import java.util.Scanner;
public class Main {
	static Scanner scn=new Scanner(System.in);
	static int ans;
	public static void main(String[] args) {
		List l=new List();
		l.delete(0);
		/*while(true) {
			System.out.println("Выберите коллекцию:\n1.List\n2.Stack\n3.Queue\n4.Deque\n5.EXIT");
			ans=scn.nextInt();
			switch (ans) {
			case 1:
				list();
				break;
			case 2:
				stack();
				break;
			case 3:
				queue();
				break;
			case 4:
				deque();
				break;
			case 5: System.out.println("---exit---"); return;
			default: System.out.println("Unncorrect input, try again: ");
				break;
			}
		}*/
	}
	public static void list() {
		List l=new List();
		while(true) {
			System.out.println("List:\n1.insert\n2.lookup\n3.delete\n4.next\n5.prev\n6.print\n7.EXIT");
			ans=scn.nextInt();
			switch (ans) {
			case 1:
				ans=scn.nextInt();
				l.insert(ans);
				break;
			case 2:
				ans=scn.nextInt();
				System.out.println(l.lookUp(ans));
				break;
			case 3:
				ans=scn.nextInt();
				l.delete(ans);
				break;
			case 4:
				System.out.println(l.next());
				break;
			case 5:
				System.out.println(l.prev());
				break;
			case 6:
				l.print();
				break;
			case 7: return;
			default: System.out.println("Unncorrect input, try again: ");
				break;
			}
		}
	}
	public static void stack() {
		Stack l=new Stack();
		while(true) {
			System.out.println("Stack:\n1.push\n2.pop\n3.top\n4.print\n5.EXIT");
			ans=scn.nextInt();
			switch (ans) {
			case 1:
				ans=scn.nextInt();
				l.push(ans);
				break;
			case 2:
				System.out.println(l.pop());
				break;
			case 3:
				System.out.println(l.top());
				break;
			case 4:
				l.print();
				break;
			case 5: return;
			default: System.out.println("Unncorrect input, try again: ");
				break;
			}
		}
	}
	public static void queue() {
		Queue l=new Queue();
		while(true) {
			System.out.println("Queue:\n1.enqueue\n2.dequeue\n3.front\n4.print\n5.EXIT");
			ans=scn.nextInt();
			switch (ans) {
			case 1:
				ans=scn.nextInt();
				l.enQueue(ans);
				break;
			case 2:
				System.out.println(l.deQueue());
				break;
			case 3:
				System.out.println(l.front());
				break;
			case 4:
				l.print();
				break;
			case 5: return;
			default: System.out.println("Unncorrect input, try again: ");
				break;
			}
		}
	}
	public static void deque() {
		Deque l=new Deque();
		while(true) {
			System.out.println("Deque:\n1.pushBack\n2.pushFront\n3.popBack\n4.popFront\n5.back\n6.front\n7.print\n8.EXIT");
			ans=scn.nextInt();
			switch (ans) {
			case 1:
				ans=scn.nextInt();
				l.pushBack(ans);
				break;
			case 2:
				ans=scn.nextInt();
				l.pushFront(ans);
				break;
			case 3:
				System.out.println(l.popBack());
				break;
			case 4:
				System.out.println(l.popFront());
				break;
			case 5:
				System.out.println(l.back());
				break;
			case 6:
				System.out.println(l.front());
				break;
			case 7:
				l.print();
				break;
			case 8: return;
			default: System.out.println("Unncorrect input, try again: ");
				break;
			}
		}
	}
}
