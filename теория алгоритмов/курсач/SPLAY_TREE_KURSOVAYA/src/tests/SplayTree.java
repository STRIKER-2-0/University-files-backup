package tests;
import java.util.ArrayDeque;
import java.util.Queue;

public class SplayTree {
	Integer data=null;
	SplayTree left=null;
	SplayTree right=null;
	SplayTree parent=null;
	
	SplayTree() {}
	SplayTree(Integer elem){
		data=elem;
	}
	public SplayTree Insert(Integer elem){     
		if(elem<data){  
	        if(left==null){    
	            left=new SplayTree(elem);
	            left.parent=this;
	            return Splay(left);
	        }
	        else   
	            return left.Insert(elem);
	    }
	    else { 
	        if(right==null){    
	            right=new SplayTree(elem);
	            right.parent=this;
	            return Splay(right);
	        }
	        else        
	        	return right.Insert(elem);
	    }
	}
	public SplayTree Search(Integer x) {
		if(x<data) 
			if(left!=null)
				return left.Search(x);
		if(x>data)
			if(right!=null)
				return right.Search(x);
		if(x==data)
			return Splay(this);
		return null;
	}
	/**метод виконуючий видаленн€ елементу 
	 * з дерева за допомогою вбудованих - 
	 * Search() & Merge() 
	 * @param x - елемент, €кий потр≥бно видалити
	 * @return - посиланн€ на новий кор≥нь 
	 * 		п≥сл€ видаленн€ або null €кщо елемент
	 * 		не знайдено
	 */
	public SplayTree Delete(Integer x) {
		SplayTree T1=Search(x);
		if (T1==null) return T1;
		SplayTree T2=T1.right;
		T1=T1.left;
		T1.parent=null;
		T2.parent=null;		
		return T1.Merge(T2);
	}
	/**метод злитт€ дерева з ≥ншим	  
	 * @param T2 - дерево, €ке потр≥бно
	 * приЇднати до поточного
	 * @return посиланн€ на кор≥нь нового дерева
	 */
	public SplayTree Merge(SplayTree T2) {
		SplayTree T1=this;
		while(T1.right!=null)
			T1=T1.right;
		Splay(T1);
		T1.right=T2;		
		return T1;
	}
	/**функц≥€, що виконуЇ одиничний л≥вий
	 * оберт вузла х щодо його батька 
	 * @param x - посиланн€ на вузол,
	 * до €кого необх≥дно застосувати оберт
	 * @return х - вузол п≥сл€ повороту
	 */
	private SplayTree Zig(SplayTree x) {
		SplayTree p=x.parent;		//збереженн€ батька вузла
		if(p.parent!=null) {		//перевизначенн€ посиланн€ з д≥дус€
			if(p==p.parent.left)p.parent.left=x;
			else p.parent.right=x;
		}
		x.parent=p.parent;		//перевизначенн€ покажчик≥в
		p.left=x.right;
		if(p.left!=null)p.left.parent=p;
		x.right=p;
		p.parent=x;
		return x;
	}
	private SplayTree Zag(SplayTree x) {
		SplayTree p=x.parent;
		if(p.parent!=null) {
			if(p==p.parent.left)p.parent.left=x;
			else p.parent.right=x;
		}
		x.parent=p.parent;
		p.right=x.left;
		if(p.right!=null)p.right.parent=p;
		x.left=p;
		p.parent=x;
		return x;
	}
	private SplayTree ZigZig(SplayTree x){
		x=Zig(x);
		return Zig(x);
	}
	private SplayTree ZagZag(SplayTree x){
		x=Zag(x);
		return Zag(x);
	}
	private SplayTree ZigZag(SplayTree x){
		x=Zig(x);
		return Zag(x);
	}
	private SplayTree ZagZig(SplayTree x){
		x=Zag(x);
		return Zig(x);
	}
	/**функц≥€, що скошуЇ дерево до заданого
	 * елементу, рекурсивно виконуючи оберти
	 * доки елемент не стане коренем
	 * @param x - посиланн€ на вузол дл€ скосу
	 * @return - усе те ж посиланн€
	 */
	private SplayTree Splay(SplayTree x) {
		if(x.parent==null)
			return x;
		if(x.parent.parent==null) {
			if(x==x.parent.left)
				return Zig(x);
			else 
				return Zag(x);
		}
		if(x==x.parent.left) {
			if(x.parent==x.parent.parent.left)
				return Splay(ZigZig(x));
			else
				return Splay(ZigZag(x));
		}
		else {
			if(x.parent==x.parent.parent.right)
				return Splay(ZagZag(x));
			else
				return Splay(ZagZig(x));
		}
	}
	
	public void print() {			//друк
		Splay(this);
		System.out.print(data+" ");
		if(left!=null)left.print();
		if(right!=null)right.print();		
	}
	public void printAsTree() {			//≥Їрарх≥чний друк
		SplayTree Null=new SplayTree();		//вместо налла, метка конца уровн€
		SplayTree Space=new SplayTree(Integer.MIN_VALUE);
		
		Queue<SplayTree> q= new ArrayDeque<>();
		int tabs=0;
        for(int i=0; i<depth(this,0); i++)		//посчет кол-ва табул€ций
            tabs=2*tabs+1;
        print_symbol(tabs);
        q.add(this);
        q.add(Null);		//ввод метки
        while(!q.isEmpty()) {
        	SplayTree temp=q.poll();
        	if(temp.data==null) {	
        		if(q.isEmpty()) {	//если очередь пуста и метка налл завершить
        			break;
        		}
        		else {		//если нет, переводит строку и вводим новую метку
        			q.add(Null);
        			System.out.println();
        			tabs=(tabs-1)/2;		//пересчет табул€ций
        			print_symbol(tabs);
        		}
        	}
        	else {
        		
        		if(temp.data==null||temp.data==Integer.MIN_VALUE)System.out.print("~");	//случай пропуска
        		else System.out.print(temp.data);
        		
        		print_symbol(2*tabs+1);
        		if(temp.left!=null)q.add(temp.left);
        		else if(tabs>0) q.add(Space);	//добавление пропуска
        		if(temp.right!=null)q.add(temp.right);
        		else if(tabs>0) q.add(Space);
        	}
        }
        System.out.println();
	}
	private int depth(SplayTree tr, int dep_count){         //глибина дерева
        if((tr.left==null)&&(tr.right==null))
            return dep_count;
        if(tr.left==null)
            return depth(tr.right, dep_count+1);
        if(tr.right==null)
            return depth(tr.left, dep_count+1);
        else return Math.max(depth(tr.left, dep_count+1), depth(tr.right, dep_count+1));
    }
	private void print_symbol(int n) {		//друк заповнювачу
		for(int i=0; i<n; i++)
			System.out.print(" ");
		
	}
}













/*





*/