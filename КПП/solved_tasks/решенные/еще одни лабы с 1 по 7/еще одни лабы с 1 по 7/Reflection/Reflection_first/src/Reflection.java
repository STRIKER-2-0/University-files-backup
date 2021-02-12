import java.lang.reflect.*;
import java.util.Scanner;

public class Reflection {
private static String str; 

	public static void getInfo(String s) throws ClassNotFoundException{
		str = "";
		Class c = Class.forName(s);
		getInfo(c);
		
	}
	
	public static void getField(Class c){
		Field[] publicFields = c.getDeclaredFields(); 
		for (Field field : publicFields) { 
		    int mods = field.getModifiers(); 
			if (Modifier.isPublic(mods)) { 
				str = str + "public" + " "; 
			} 
			if (Modifier.isPrivate(mods)) { 
				str = str + "private" + " "; 
			}
			if (Modifier.isStatic(mods)) { 
				str = str + "static" + " "; 
			}
			if (Modifier.isAbstract(mods)) { 
				str = str + "abstract" + " ";
			} 
			if (Modifier.isFinal(mods)) { 
				str = str + "final" + " "; 
			} 
		    str = str + field.getType() + " "; 
		   // if(field.getClass().isArray())
		    	
		    	str = str + field.getName() + "; \n";  
		}
	}
	
	public static void getMethodsWOPar(Class c){
		str = "";
		int h = 1;
		Method[] methods = c.getMethods(); 
		for (Method method : methods) { 
			int mods = method.getModifiers(); 
			if (method.getParameterCount() != 0)
				continue;
			str = str + h + ") ";
			if (Modifier.isPublic(mods)) { 
				str = str + "public" + " "; 
			} 
			if (Modifier.isPrivate(mods)) { 
				str = str + "private" + " "; 
			}
			if (Modifier.isStatic(mods)) { 
				str = str + "static" + " "; 
			}
			if (Modifier.isAbstract(mods)) { 
				str = str + "abstract" + " ";
			} 
			if (Modifier.isFinal(mods)) { 
				str = str + "final" + " "; 
			} 
			str = str + method.getReturnType().getName() + " ";
		    str = str + method.getName(); 	
		    str = str + "(";
		    Class[] paramTypes = method.getParameterTypes(); 
		    int j = 0;
		    for (Class paramType : paramTypes) { 
		    	str = str + paramType.getName() + " par" + j +" ";
		        j++;
		    } 
		    str = str + ") \n";
		    h++;
		} 
	}
	
	public static Method getMethodsWOPar(Class c, int h) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		str = "";
		int i = 1;
		Method[] methods = c.getMethods(); 
		Method m = null;
		for (Method method : methods) { 
			if (method.getParameterCount() != 0)
				continue;
			if(i != h){
				i++;
				continue;
			}
			m = method;
		  break;
		}
		if (m.isAccessible() == false)
		m.setAccessible(true);
		return m;
				
	}
	
	public static void getConstr(Class c){
		Constructor[] constructors = c.getConstructors(); 
		for (Constructor constructor : constructors) { 
		    int mods = constructor.getModifiers(); 
			if (Modifier.isPublic(mods)) { 
				str = str + "public" + " "; 
			} 
			if (Modifier.isPrivate(mods)) { 
				str = str + "private" + " "; 
			}
			if (Modifier.isStatic(mods)) { 
				str = str + "static" + " "; 
			}
			if (Modifier.isAbstract(mods)) { 
				str = str + "abstract" + " ";
			} 
			if (Modifier.isFinal(mods)) { 
				str = str + "final" + " "; 
			} 
			str = str + "(";
			 Class[] paramTypes = constructor.getParameterTypes(); 
			 int j = 0;
		    for (Class paramType : paramTypes) {
		        str = str + paramType.getName() + " par" + j +" ";
		        j++;
		    } 
		    str = str + ") \n";
		} 
	}
	
	public static void getMeth(Class c){
		Method[] methods = c.getMethods(); 
		for (Method method : methods) { 
			int mods = method.getModifiers(); 
			if (Modifier.isPublic(mods)) { 
				str = str + "public" + " "; 
			} 
			if (Modifier.isPrivate(mods)) { 
				str = str + "private" + " "; 
			}
			if (Modifier.isStatic(mods)) { 
				str = str + "static" + " "; 
			}
			if (Modifier.isAbstract(mods)) { 
				str = str + "abstract" + " ";
			} 
			if (Modifier.isFinal(mods)) { 
				str = str + "final" + " "; 
			} 
			str = str + method.getReturnType().getName() + " ";
		    str = str + method.getName(); 	
		    str = str + "(";
		    Class[] paramTypes = method.getParameterTypes(); 
		    int j = 0;
		    for (Class paramType : paramTypes) { 
		    	str = str + paramType.getName() + " par" + j +" ";
		        j++;
		    } 
		    str = str + ") \n";
		} 
	}
	
	public static void getInterf(Class c){
		Class[] interfaces = c.getInterfaces(); 
		for(Class cInterface : interfaces) { 
		    str = str + cInterface.getName() + ", \n";
		}	
	}
	
	public static void getSup(Class c){
		str = str + c.getSuperclass() + ", \n";
	}
	
	public static void getN(Class c){
		str = str + c.getName() + ", ";
	}
	
	public static void getMod(Class c){
		int mods = c.getModifiers(); 
		if (Modifier.isPublic(mods)) { 
			str = str + "public" + ", "; 
		} 
		if (Modifier.isAbstract(mods)) { 
			str = str + "abstract" + ", ";
		} 
		if (Modifier.isFinal(mods)) { 
			str = str + "final" + ", "; 
		} 
	}
	
	public static void getPack(Class c){
		str = str + c.getPackage() + ", \n";
	}
	
	
	public static void getInfo(Class c){
		getPack(c);
		getMod(c);
		str = str + " class";
		getN(c);
		str = str + " extends ";
		getSup(c);
		str = str + " implements ";
		getInterf(c);
		str = str + "{ \n";
		getField(c);
		str = str + "\n";
		getConstr(c);
		str = str + "\n";
		getMeth(c);
	}
	
	public void setStr(String s){
		this.str = s;
	}
	
	public String getStr(){
		return this.str;
	}
	
	public static void main(String[] args) throws ClassNotFoundException{
		System.out.println("Enter class name, like java.lang.String");
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		getInfo(s);
		System.out.println(str);
	}
}
