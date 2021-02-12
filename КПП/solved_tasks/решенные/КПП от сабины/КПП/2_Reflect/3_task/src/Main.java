import java.lang.reflect.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Object obj=null;
        Object res=null;
        Class cls = null;
        Analys analys=new Analys();
        int menu=-1;
        while (true) {
            System.out.println("1-Создать объект");
            System.out.println("2-Отобразить состояние");
            System.out.println("3-Отобразить методы и выполнить");
            System.out.println("0-Выход");

            while (true)
                try {
                    menu=sc.nextInt();
                    if(menu<0||menu>3) {System.out.println("Нет такого номера, повторите ввод");continue;}
                    break;
                }catch (InputMismatchException e){
                    sc.nextLine();
                    System.out.println("Некорректный ввод, повторите ввод");
                }

            switch (menu){
                case 1:
                    sc.nextLine();
                    System.out.println("Введите полное имя класса");
                    //получаем класс
                    while (true)
                        try {
                            cls = Class.forName(sc.nextLine());
                            try {
                                obj=createObjConstr(cls);
                            } catch (IllegalAccessException e) {
                                //e.printStackTrace();
                            } catch (InvocationTargetException e) {
                                //e.printStackTrace();
                            } catch (InstantiationException e) {
                                //e.printStackTrace();
                            }
                            break;
                        } catch (ClassNotFoundException e) {
                            System.out.println("Нет такого класса введите еще раз");
                            continue;
                        //от createObjConstr
                        }
                    break;
                case 2:
                    if(obj==null){
                        System.out.println("Объект не создан");
                        break;
                    }
                    if (getStatus(obj).length() != 0) {
                        System.out.println("Состояние:");
                        System.out.println(getStatus(obj));
                    } else System.out.println("У объекта доступных полей нет");
                    break;
                case 3:

                    if(obj==null){
                        System.out.println("Объект не создан");
                        break;
                    }
                    boolean flag=true;
                    while (flag)
                        if (analys.getMethodsS(cls).length() != 0) {
                            System.out.println("Список открытых методов:");
                            System.out.println(analys.getMethodsS(cls));
                            System.out.println("Введите порядковый номер метода(без параметров)(0-выйти из этого пункта меню)[1," + analys.getMethods().length + "]");
                            int num = 1;
                            while (true)
                                try {
                                    num = sc.nextInt();
                                    if(num==0) {flag=false;break;}
                                    else if (num < 0 || num > analys.getMethods().length) {
                                        System.out.println("Нет такого номера метода, повторите ввод");
                                        continue;
                                    }
                                    res=runMethod(analys.getMethods()[num-1],obj);
                                    if (res!=null) System.out.println("result: "+res);
                                    break;
                                } catch (InputMismatchException e) {
                                    sc.nextLine();
                                    System.out.println("Неверныый ввод, повторите");
                                // метод runMethod
                                } catch (IllegalAccessException e) {
                                    e.printStackTrace();
                                } catch (InstantiationException e) {
                                    e.printStackTrace();
                                } catch (InvocationTargetException e) {
                                    e.printStackTrace();
                                }
                        } else System.out.println("У объекта доступных методов нет");
                    break;
                case 0:return;
            }
        }
    }

    public static Object runMethod(Method method,Object obj) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        Object[] args=new Object[method.getParameters().length];
        Parameter[] parameters=method.getParameters();
        for (int i = 0; i < method.getParameters().length; i++) {
            args[i]=createObjectParam(parameters[i].getType());
        }
        return method.invoke(obj,args);
    }
    public static Object createObjectParam(Class cls) throws IllegalAccessException, InvocationTargetException, InstantiationException {
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
            }else arg[i] = createObjectParam(constructors[number - 1].getParameterTypes()[i]);
        }
        System.out.println("Объект "+cls.getSimpleName()+" создан");
        return constructors[number - 1].newInstance(arg);
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
    public static String getStatus(Object obj) {
        StringBuilder stringBuilder=new StringBuilder();
        Class cls=obj.getClass();
        Field[] fields=cls.getDeclaredFields();
        for(int i=0;i<fields.length;i++){
            try {
            fields[i].setAccessible(true);
            if (fields[i].getType().isPrimitive()) {
                    stringBuilder.append(fields[i].getType() + " " + fields[i].getName() + ": " + fields[i].get(obj));
            }else stringBuilder.append(fields[i].getType().getSimpleName()+" "+ fields[i].getName()+": ("+getStatusLine(fields[i].get(obj))+")");
            if(i!=fields.length-1) stringBuilder.append("\n");

            } catch (IllegalAccessException e) {
                System.out.println("Поле не доступно");
                //e.printStackTrace();
            }
        }
        return stringBuilder.toString();
    }
    public static String getStatusLine(Object obj) throws IllegalAccessException {
        StringBuilder stringBuilder=new StringBuilder();
        Class cls=obj.getClass();
        Field[] fields=cls.getDeclaredFields();
        for(int i=0;i<fields.length;i++){
            if (fields[i].getType().isPrimitive()) {
                fields[i].setAccessible(true);
                stringBuilder.append(fields[i].getType() + " " + fields[i].getName() + ": " + fields[i].get(obj));
            }
            else {
                fields[i].setAccessible(true);
                stringBuilder.append(fields[i].getType().getSimpleName()+" "+ fields[i].getName()+": ("+getStatusLine(fields[i].get(obj))+")");
            }
            if(i!=fields.length-1) stringBuilder.append("; ");
        }
        return stringBuilder.toString();
    }
}
