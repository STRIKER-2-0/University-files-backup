import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class BTree {
	BTree left=null;	//левый потомок
	BTree right=null;	//правый потомок
	int count=0;		//кол-во поторений символа
	char sym='\0';		//символ. тильда- по умолчанию	
	int depth=1;		//глубина дерева
	private String coding;
	
	BTree(){}
	BTree(char sym, int count){
		this.sym=sym;
		this.count=count;
	
	}
	
	public BTree add(BTree b) {		
		BTree empt=new BTree();
		empt.left=this;
		empt.right=b;
		empt.count=empt.left.count+empt.right.count;
		empt.depth=Math.max(empt.left.depth, empt.right.depth)+1;
		return empt;
	}
	public String encode(char a) {		//закодировать символ
		BTree temp=this;
		coding="";
		while(temp.sym!=a) {
			if(temp.left!=null&&temp.left.isInTree(a)) {
				coding+="0";
				temp=temp.left;
			}
			if(temp.right!=null&&temp.right.isInTree(a)) {
				coding+="1";
				temp=temp.right;
			}			
		}
		return coding;
	}
	public boolean isInTree(char a) {		//есть ли в дереве
		Stack<BTree> s=new Stack<>();
		BTree temp=this;
		s.add(temp);
		while(!s.isEmpty()) {
			temp=s.pop();
			if(temp.right!=null)s.add(temp.right);
			if(temp.left!=null)s.add(temp.left);			
			if(temp.sym==a)return true;
		}
		return false;
	}
	public void print() {			//печать
		System.out.print(sym);
		if(left!=null)left.print();
		if(right!=null)right.print();
		
	}
	public void printAsTree() {			//печать как дерево, по уровням
		BTree Null=new BTree();		//вместо налла, метка конца уровня
		Null.count=-1;
		BTree Space=new BTree();		//вместо отсутствия элемента
		Space.sym=' ';
		Space.count=-2;
		
		Queue<BTree> q= new ArrayDeque<>();
		int tabs=0;
        for(int i=0; i<depth; i++)		//посчет кол-ва табуляций
            tabs=2*tabs+1;
        print_symbol(tabs);
        q.add(this);
        q.add(Null);		//ввод метки
        while(!q.isEmpty()) {
        	BTree temp=q.poll();
        	if(temp.count==-1) {	
        		if(q.isEmpty()) {	//если очередь пуста и метка налл завершить
        			break;
        		}
        		else {		//если нет, переводит строку и вводим новую метку
        			q.add(Null);
        			System.out.println();
        			tabs=(tabs-1)/2;		//пересчет табуляций
        			print_symbol(tabs);
        		}
        	}
        	else {
        		if(temp.sym=='\0')System.out.print("??");
        		else if(temp.count==-1)System.out.print(" ");	//случай пропуска
        		else if(temp.sym==' '&&temp.count!=-2)System.out.print("\" \""); //случай пробела
        		else System.out.print(temp.sym);
        		
        		print_symbol(2*tabs+1);
        		if(temp.left!=null)q.add(temp.left);
        		else if(tabs>0) q.add(Space);	//добавление пропуска
        		if(temp.right!=null)q.add(temp.right);
        		else if(tabs>0) q.add(Space);
        	}
        }
	}
	private void print_symbol(int n) {		//печать табуляций 
		for(int i=0; i<n; i++)
			System.out.print(" ");
	}
}
