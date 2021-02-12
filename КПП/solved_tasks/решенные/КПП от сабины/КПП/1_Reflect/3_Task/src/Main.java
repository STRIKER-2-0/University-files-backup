import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        TestClass obj=new TestClass();
        Object arg[]=new Object[2];
        arg[0]=3.5;
        arg[1]=2;
        try {
            System.out.println(runMeth(obj,"GetRes",arg));
            //runMeth(obj,"GetRes",arg);
        } catch (FunctionNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Object runMeth(Object obj, String nameMeth, Object[] args) throws InvocationTargetException, IllegalAccessException, FunctionNotFoundException {
        Object res=null;
        Class cls=obj.getClass();
        Method[] methods=cls.getMethods();
        int i=0;
        for(i=0;i<methods.length;i++)
            if(methods[i].getName().equals(nameMeth))
                try {
                    res=methods[i].invoke(obj,args);
                    break;
                }catch (IllegalArgumentException e){
                }
        if(i==methods.length) throw new FunctionNotFoundException("Метод не найден");
        return res;
    }
}
