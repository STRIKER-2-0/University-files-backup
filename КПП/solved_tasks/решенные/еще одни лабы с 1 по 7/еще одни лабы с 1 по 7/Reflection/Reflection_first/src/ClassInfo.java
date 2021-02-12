import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class ClassInfo {
	
	private static Reflection ref; 
	
	public ClassInfo(){
		ref = new Reflection();
		
	}
	
	public static void Info(Object obj){
		Class c = obj.getClass(); 
		ref.getField(c);
		ref.setStr(ref.getStr() + "\n");
		ref.getMeth(c);
	}
	
	public static void main(String[] args) throws ClassNotFoundException {
		Scanner in = new Scanner(System.in);
		ClassInfo c = new ClassInfo();
		Object obj = 456;
		c.Info(new java.lang.Object());
		System.out.println(ref.getStr());
		Class cl = obj.getClass();
		ref.getMethodsWOPar(cl);
		System.out.println("Choose one of methods:");
		System.out.println(ref.getStr());
		int t = in.nextInt();
		try {
			Method m = ref.getMethodsWOPar(cl, t);
		System.out.println("Result: " + m.invoke(obj));
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
