
public class Main {
	public static void main(String[] args) {
		SplayTree b=new SplayTree(8);
		b=b.Insert(4);
		b=b.Insert(5);
		b=b.Insert(3);
		b=b.Insert(23);		
		b=b.Insert(6);
		b=b.Insert(11);
		b=b.Insert(50);
		b=b.Insert(12);
		b.printAsTree();
		/*
		SplayTree b2=new SplayTree(100);
		b2=b2.Insert(200);
		b2=b2.Insert(75);
		b2.printAsTree();
		
		b=b.Merge(b2);
		b.printAsTree();
		//System.out.println(b.Merge(b).data);
		/*
		/*
		
		/*
		b.print();
		System.out.println();
		
		b.printAsTree();		
		b=b.Splay(b.right.left.right);
		b.printAsTree();
		*/
	}
}
