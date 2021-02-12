import java.lang.reflect.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CrafterClass {

    public static Class getType(String str) throws ClassNotFoundException {
        int i=0;
        for(i=0;i<str.length();i++)
            if(str.charAt(i)=='[') break;
        if(str.substring(0,i).equals("byte")) return byte.class;
        if(str.substring(0,i).equals("short")) return short.class;
        if(str.substring(0,i).equals("char")) return char.class;
        if(str.substring(0,i).equals("int")) return int.class;
        if(str.substring(0,i).equals("long")) return long.class;
        if(str.substring(0,i).equals("float")) return float.class;
        if(str.substring(0,i).equals("double")) return double.class;
        if(str.substring(0,i).equals("boolean")) return boolean.class;
        return Class.forName(str.substring(0,i));
    }
    public static int[] getSize(String str){
        int count=0;
        for(int i=0;i<str.length();i++)
            if(str.charAt(i)=='[') count++;
        int[] res=new int[count];
        for(int i=0,j=0;i<str.length();i++)
            if(Character.isDigit(str.charAt(i)))
                res[j++]=Integer.parseInt(String.valueOf(str.charAt(i)));
        return res;
    }
    public static void print(Object obj,int[] size,int k){
        if(k==size.length-1) {
            for (int i = 0; i < size[k]; i++) {
                System.out.print(Array.get(obj, i));
                if(i!=size[k]-1) System.out.print(",");
            }
        }else{
            for (int i = 0; i < size[k]; i++) {
                System.out.print("{");
                print(Array.get(obj, i), size, k + 1);
                System.out.print("}");
                if(i!=size[k]-1) System.out.print(",");
            }
        }
    }
    public static void fill(Object arr,int[] size,int k){
        if(k==size.length-1) {
            for (int i = 0; i < size[k]; i++) {
                System.out.println((i+1)+" элемент");
                Scanner sc=new Scanner(System.in);
                try {
                    Array.set(arr,i,createObjConstr(Array.get(arr,i).getClass()));
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }else{
            for (int i = 0; i < size[k]; i++) {
                System.out.println((i+1)+" строка");
                fill(Array.get(arr, i), size, k + 1);
            }
        }
    }
    public static Object createObjConstr(Class cls) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        System.out.println("Начало создания "+cls.getSimpleName());
        Object res=null;
        if((res=getVal(cls.getSimpleName()))!=null) return res;
        //это объект
        Scanner sc = new Scanner(System.in);
        Constructor[] constructors = cls.getConstructors();
        System.out.println("Конструкторы");
        for (int i = 0; i < constructors.length; i++) {
            System.out.print((i + 1) + "-" + constructors[i].getName() + "(");
            Parameter[] parameters = constructors[i].getParameters();
            for (int j = 0; j < parameters.length; j++) {
                System.out.print(parameters[j].getType().getSimpleName() + " " + parameters[j].getName());
                if (!(j == parameters.length - 1)) System.out.print(",");
            }
            System.out.println(")");
        }

        System.out.println("Введите номер");
        int number = -1;
        while (true)
            try {
                number = sc.nextInt();
                if (number < 1 || number > constructors.length) {
                    System.out.println("Нет такого номера, повторите ввод");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Неверный ввод, повторите");
                sc.nextLine();
            }
        Object[] arg = new Object[constructors[number - 1].getParameters().length];
        for (int i = 0; i < arg.length; i++) {
            if (constructors[number - 1].getParameterTypes()[i].getSimpleName().equals("String")) {
                System.out.println("Введите строку");
                arg[i]=sc.next();
            }else arg[i] = createObjConstr(constructors[number - 1].getParameterTypes()[i]);
        }
        System.out.println("Объект "+cls.getSimpleName()+" создан");
        return constructors[number - 1].newInstance(arg);
    }
    public static Object getVal(String str){
        Scanner sc=new Scanner(System.in);
        if(str.equals("byte")){
            System.out.println("Введите byte");
            return sc.nextByte();
        }
        if(str.equals("short")){
            System.out.println("Введите short");
            return sc.nextShort();
        }
        if(str.equals("char")){
            System.out.println("Введите char");
            return sc.next().charAt(0);
        }
        if(str.equals("int")){
            System.out.println("Введите int");
            return sc.nextInt();
        }
        if(str.equals("long")){
            System.out.println("Введите long");
            return sc.nextLong();
        }
        if(str.equals("float")){
            System.out.println("Введите float");
            return sc.nextFloat();
        }
        if(str.equals("double")){
            System.out.println("Введите double");
            return sc.nextDouble();
        }
        if(str.equals("boolean")){
            System.out.println("Введите boolean");
            return sc.nextBoolean();
        }
        return null;
    }
    public static Object changeSize(Object arr,String cls,int[] newsize,int[] oldsize) throws ClassNotFoundException {
        Object res= Array.newInstance(CrafterClass.getType(cls),newsize);
        copy(res,arr,newsize,oldsize,0);
        return res;
    }
    private static  void copy(Object newObj,Object oldObj,int[] newsize,int[] oldsize,int k){
        int sizeForCopy=newsize[k]<oldsize[k]?newsize[k]:oldsize[k];
        if(newsize[k]<oldsize[k]) sizeForCopy=newsize[k];
        if (k+1==newsize.length){
            for(int i=0;i<sizeForCopy;i++)
                Array.set(newObj,i,Array.get(oldObj,i));
        }else
        for(int i=0;i<sizeForCopy;i++){
            copy(Array.get(newObj,i),Array.get(oldObj,i),newsize,oldsize,k+1);
        }
    }
}
