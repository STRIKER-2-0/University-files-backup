import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class Operating {
	public static Scanner in = new Scanner(System.in);
	public static String str = "";

	public static Object creating(Class cl) throws ClassNotFoundException,
	InstantiationException, IllegalAccessException, IllegalArgumentException,
	InvocationTargetException{
		Constr constr = new Constr(cl);
		Constructor[] constructors = constr.getConstr();
		int i = 1;
		Constructor constructor1 = null;
		for (Constructor constructor : constructors) { 
		    int mods = constructor.getModifiers(); 
		    str = str + i + ") ";
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
			str = str + constructor.getName() + "(";
			constructor1 = constructor;
			 Class[] paramTypes = constructor.getParameterTypes(); 
			 int j = 0;
		    for (Class paramType : paramTypes) {
		        str = str + paramType.getName() + " par" + j +" ";
		        j++;
		    } 
		    str = str + ") \n";
		    i++;
		} 
		
	System.out.println(str + "\n" +  "Choose the constructor");
	int x = in.nextInt();
	x = x-1;
	 
	if (constructor1.getParameterCount() == 0){
		return constr.getConstr(x).newInstance();
	}
	System.out.println("Enter the parametrs");
		Class[] paramTypes = constr.getConstr(x).getParameterTypes();
	for (Class paramType : paramTypes) {
        str = str + paramType.getName() + " par" +"\n";
    } 
	System.out.println(str + "\n" + "Creating parametrs");
	Object[] arr = new Object[paramTypes.length];
	i = 0;
	for(Class paramType: paramTypes){
		arr[i] = getParam(paramType);
	}
			Object fin = constr.getConstr(x).newInstance(arr);    //DODELAT
		return fin;
	}
	
	public static Object[] CheckArray(Class paramType) throws InstantiationException,
	IllegalAccessException, ClassNotFoundException, IllegalArgumentException, 
	InvocationTargetException{
		System.out.println("Creating Array of " + paramType.getName());
		System.out.println("Enter the number of values:");
		int i = in.nextInt();
		Object[] arr = new Object[i];
		Class a = paramType.getComponentType();
		int j = 0;
		for(Object b: arr){
			arr[j] = getParam(a);
			j++;
		}
		return arr;
	}
	
	public static Object getParam(Class paramType) throws InstantiationException,
	IllegalAccessException, ClassNotFoundException, IllegalArgumentException, 
	InvocationTargetException{
		Object obj = null;
		if(paramType.isArray()){
			obj = CheckArray(paramType);
		}
		else if(paramType == int.class){
			System.out.println("Input the int value: ");
			int a = in.nextInt();
			obj = (int)a;
		}
		else if(paramType == double.class){
			System.out.println("Input the double value: ");
			double a = in.nextDouble();
			obj = (double)a;
		}
		else if(paramType == long.class){
			System.out.println("Input the long value: ");
			long a = in.nextLong();
			obj = (long)a;
		}
		else if(paramType == boolean.class){
			System.out.println("Input the boolean value: ");
			boolean a = in.nextBoolean();
			obj = (boolean)a;
		}
		else if(paramType == short.class){
			System.out.println("Input the short value: ");
			short a = in.nextShort();
			obj = (short)a;
		}
		else if(paramType == float.class){
			System.out.println("Input the float value: ");
			float a = in.nextFloat();
			obj = (float)a;
		}
		else if(paramType == byte.class){
			System.out.println("Input the byte value: ");
			int a = in.nextInt();
			obj = (byte)a;
		}
		else if(paramType == String.class){
			System.out.println("Input the String value: ");
			String a = in.nextLine();
			obj =(String)a;
		}
		else{
			System.out.println("Creating " + paramType.getName() + " object");
			obj = creating(paramType);
		}
		return obj;
	}
	
	
	public static void main(String[] args) throws ClassNotFoundException,
	InstantiationException, IllegalAccessException, IllegalArgumentException, 
	InvocationTargetException{
		System.out.println("Enter the class Name");
		String s = in.nextLine();
		Class cl = Class.forName(s);
		System.out.println(Operating.creating(cl));
	}
}
