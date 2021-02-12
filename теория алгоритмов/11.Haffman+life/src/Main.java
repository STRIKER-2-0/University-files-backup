
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
public class Main {
	public final static int MAX_ENCODING_SIZE=1279;
	public static void main(String[] args) {
		//проиритетная очередь с переопределением компаратора
		PriorityQueue<BTree> q=new PriorityQueue<>(new Comparator<BTree>() {
			@Override
			public int compare(BTree o1, BTree o2) {
				return (int)(o1.count-o2.count);
			}			
		});
		Scanner scan=new Scanner(System.in);
		System.out.print("Введите строку: ");
		String line=scan.nextLine();//"beep boop beer!";
		int counts[] = new int[MAX_ENCODING_SIZE];	//массив повторений
		for (char i : line.toCharArray()) 
			counts[(int)i]++;  //запись повторений
		ArrayList<Character> letters = new ArrayList<>();
		ArrayList<Integer> freqs = new ArrayList<>();
		ArrayList<String> codes = new ArrayList<>();
		for (int i = 0; i < counts.length; i++) {	//добаление в очередь
			if(counts[i]!=0) {
				q.add(new BTree((char)i, counts[i]));
				letters.add((char)i);
				freqs.add(counts[i]);
			}
		}
		BTree b=null;
		while (!q.isEmpty()) {		//создание дерева хаффмана из очереди
			b=q.poll();
			if(q.isEmpty())break;
			b=b.add(q.poll());
			q.add(b);
		}
		for (Character letter : letters) 
			codes.add(b.encode(letter));
		System.out.print("Закодированная строка: ");
		for (char letter : line.toCharArray()) {
			System.out.print(codes.get(letters.indexOf(letter))+" ");
		}
		System.out.println();
		for (int i = 0; i < codes.size(); i++) {
			System.out.println(letters.get(i)+": "+freqs.get(i)+" -> "+codes.get(i));
		}	
		b.printAsTree();
		scan.close();
	}	
}

