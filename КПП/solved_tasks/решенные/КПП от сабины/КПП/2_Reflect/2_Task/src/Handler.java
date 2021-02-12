import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Handler implements InvocationHandler {
    Object obj;
    public Handler(Object obj){
        this.obj=obj;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long time=System.nanoTime();
        Object obj=null;
        obj=method.invoke(this.obj,args);
        System.out.println("Time: "+String.valueOf(System.nanoTime()-time)+"ns");
        System.out.print(method.getName()+"(");
        for(int i=0;i<method.getParameters().length;i++) {
            System.out.print(method.getParameters()[i].getType().getSimpleName()+" "+method.getParameters()[i].getName());
            if (!(i==method.getParameters().length-1))
                System.out.print(", ");
        }
        System.out.println(")");
        if(obj==null) System.out.println("res: void");
        else System.out.println("res: "+obj);
        return null;
    }
}
