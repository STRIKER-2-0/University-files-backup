import java.lang.reflect.*;

public class Analys {
    private  Method[] methods;

    public String getMethodsS(Class cls) {
        StringBuilder stringBuilder = new StringBuilder();

        methods = cls.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            stringBuilder.append(i + 1 + "- " + getModif(methods[i].getModifiers()) + methods[i].getReturnType().getSimpleName() + " " + methods[i].getName() + "(");
            Parameter[] param = methods[i].getParameters();
            for (Parameter p : param)
                stringBuilder.append(p.getType().getSimpleName() + " " + p.getName() + ", ");
            if (param.length != 0)
                stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
            stringBuilder.append(");\n");
        }
        return stringBuilder.toString();
    }

    public  Method[] getMethods() {
        return methods;
    }
    private  String getModif(int m){
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