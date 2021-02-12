import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectMethod {

	public ReflectMethod(){}
	
	public Method getMeth(Class c, String s){
		Method m = null;
		Method[] methods = c.getMethods(); 
		for (Method method : methods) {  
			if (method.getName().equals(s)){
				m = method;
			}
		} 
		return m;
	}
	
	public void ReflectMeth(Object obj, String s, Object... par){
		try{
			Class c = obj.getClass();
			Method m = getMeth(c, s);
			if(m == null)
				throw new Exception();
			else{
				System.out.println("Result: " + m.invoke(obj, par));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		ReflectMethod rm = new ReflectMethod();
		String s = "rdfhdd";
		Object obj = (Object)s;
		String str = "charAt";
		int par2 = 2;
		rm.ReflectMeth(s, str, par2);
	}
}
