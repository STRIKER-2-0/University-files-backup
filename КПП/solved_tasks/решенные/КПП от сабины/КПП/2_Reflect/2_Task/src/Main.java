import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        Student student=new Student();
        Person proxy = (Person) Proxy.newProxyInstance(Student.class.getClassLoader(),Student.class.getInterfaces(),new Handler(student));
        proxy.getGroup();
    }
}