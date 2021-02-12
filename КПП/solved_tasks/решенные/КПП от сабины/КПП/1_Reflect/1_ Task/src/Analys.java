import java.lang.reflect.*;

public class Analys {
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
    public static String res(Object obj){
        StringBuilder stringBuilder=new StringBuilder();

        Class cls;
        if (obj.getClass().getSimpleName().equals("String")&&!((String)obj).equals(""))
        try {
            //cls=Class.forName((String)obj);
            cls=getType((String) obj);
        } catch (ClassNotFoundException e) {
            //такого класса нет
            return "ClassNotFound";
        }
        else cls=obj.getClass();
        stringBuilder.append("Полное имя "+cls.getCanonicalName()+"\r\n");
        stringBuilder.append("Пакет "+cls.getPackage()+"\r\n");
        stringBuilder.append(getModif(cls.getModifiers()));
        stringBuilder.append(cls.getSimpleName()+" ");
        if(cls.getSuperclass()!=null)
            stringBuilder.append("extends "+cls.getSuperclass().getSimpleName()+" ");
        Class[] clss=cls.getInterfaces();
        if(clss.length!=0) {
            stringBuilder.append("implements ");
            for (Class c : clss)
                stringBuilder.append(c.getSimpleName()+", ");
        }

        stringBuilder.append("{\n");
        Field[] fields=cls.getDeclaredFields();
        if(fields.length!=0){
            stringBuilder.append("\t//Поля\n");
            for(Field f:fields)
                stringBuilder.append("\t"+getModif(f.getModifiers())+f.getName()+";\n");
        }

        Constructor[] constr=cls.getDeclaredConstructors();
        if(constr.length!=0) {
            stringBuilder.append("\n\t//Конструкторы\n");
            for (int i = 0; i < constr.length; i++) {
                stringBuilder.append("\t" + getModif(constr[i].getModifiers()) + cls.getSimpleName() + "(");
                Parameter[] param=constr[i].getParameters();
                for(Parameter p:param)
                    stringBuilder.append(p.getType().getSimpleName()+" "+p.getName()+", ");
                if(param.length!=0)
                    stringBuilder.delete(stringBuilder.length()-2,stringBuilder.length());
                stringBuilder.append(");\n");
            }
        }

        Method[] methods=cls.getDeclaredMethods();
        if(methods.length!=0){
            stringBuilder.append("\n\t//Методы\n");
            for(Method m:methods){
                stringBuilder.append("\t" + getModif(m.getModifiers()) + m.getReturnType().getSimpleName() + " " + m.getName() + "(");
                Parameter[] param=m.getParameters();
                for(Parameter p:param)
                    stringBuilder.append(p.getType().getSimpleName()+" "+p.getName()+", ");
                if(param.length!=0)
                    stringBuilder.delete(stringBuilder.length()-2,stringBuilder.length());
                stringBuilder.append(");\n");
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
    public static String getModif(int m){
        StringBuilder stringBuilder=new StringBuilder();
        if (Modifier.isPublic(m)) stringBuilder.append("public ");
        if (Modifier.isProtected(m)) stringBuilder.append("protected ");
        if (Modifier.isPrivate(m)) stringBuilder.append("private ");
        if (Modifier.isStatic(m)) stringBuilder.append("static ");
        if (Modifier.isAbstract(m)) stringBuilder.append("abstract ");
        if (Modifier.isVolatile(m)) stringBuilder.append("volatile ");
//        if (Modifier.isTransient(m)) stringBuilder.append("transient ");
//        if (Modifier.isNative(m)) stringBuilder.append("native ");
//        if (Modifier.isStrict(m)) stringBuilder.append("strict ");
        if (Modifier.isSynchronized(m)) stringBuilder.append("synchronized ");
        if (Modifier.isFinal(m)) stringBuilder.append("final ");
        if (Modifier.isInterface(m)) stringBuilder.append("interface ");
        return stringBuilder.toString();
    }
}
