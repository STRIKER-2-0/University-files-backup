package lab6;
import java.util.Scanner;

public class Test {
	public static void main(String ags[]) {
		int ans;
		Container c;
		Scanner scan=new Scanner(System.in);
		while(true){
			System.out.println("1.Stack\n2.Queue\n3.Exit");
			ans=scan.nextInt();
			if(ans==1){
				c=new Stack();
				dialog(c,ans,scan);
			}
			else if(ans==2){
				c=new Queue();
				dialog(c,ans,scan);
			}
			else if(ans==3){
				scan.close();
				System.out.println("---Test finished---");
				return;
			}
			else System.out.println("Uncorrect value!!");
		}
	}
	public static void dialog(Container c,int ans,Scanner scan) {
		while(true){
			System.out.println("\n1.Put\n2.Get\n3.Get size\n4.Clear\n5.Print\n6.Exit");
			ans=scan.nextInt();
			switch(ans){
				case 1: System.out.print("Enter a value: ");
						 ans=scan.nextInt();
						 c.put(ans);
						 break;
				case 2: System.out.println("Value from the container: "+c.get());
						 break;
				case 3: System.out.println("Size of the container: "+c.getSize());
						 break;
				case 4: c.clear();
						 System.out.println("The container cleared!");
						 break;
				case 5: c.print(); break;
				case 6: System.out.println("Exit to the main menu"); return;
				default: System.out.println("Uncorrect value!!");
			}
		}
	}
}