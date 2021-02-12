import java.lang.reflect.InvocationTargetException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, InvocationTargetException {
        Scanner sc=new Scanner(System.in);
        int menu=1;
        Class cls=null;
        Object obj=null;
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
                    System.out.println("Введите название класса");
                    while (true)
                    try {
                        sc.nextLine();
                        cls=Class.forName(sc.nextLine());
                        System.out.println("Создание объекта");
                        obj = cls.newInstance();
                        System.out.println("Объект создан");
                        break;
                    } catch (ClassNotFoundException e) {
                        System.out.println("Не получается найти данный класс, повторте ввод");
                    }
                    break;
                case 2:
                    if(obj==null){
                        System.out.println("Объект не создан");
                        break;
                    }
                    if (Analys.getStatus(obj).length() != 0) {
                        System.out.println("Состояние:");
                        System.out.println(Analys.getStatus(obj));
                    } else System.out.println("У объекта доступных полей нет");
                    break;
                case 3:
                    if(obj==null){
                        System.out.println("Объект не создан");
                        break;
                    }
                    boolean flag=true;
                    while (flag)
                    if (Analys.getMethodsS(cls).length() != 0) {
                        System.out.println("Список открытых методов:");
                        System.out.println(Analys.getMethodsS(cls));
                        System.out.println("Введите порядковый номер метода(без параметров)(0-выйти из этого пункта меню)[1," + Analys.getMethods().length + "]");
                        int num = 1;
                        while (true)
                            try {
                                num = sc.nextInt();
                                if(num==0) {flag=false;break;}
                                else if (num < 0 || num > Analys.getMethods().length) {
                                    System.out.println("Нет такого номера метода");
                                    continue;
                                } else if (Analys.getMethods()[num - 1].getParameterTypes().length != 0) {
                                    System.out.println("Этот метод с параметрами, выберите другой");
                                    continue;
                                }
                                System.out.println("Result: "+Analys.getMethods()[num - 1].invoke(obj, null));
                                break;
                            } catch (InputMismatchException e) {
                                sc.nextLine();
                                System.out.println("Неверныый ввод, повторите");
                            }
                    } else System.out.println("У объекта доступных методов нет");
                    break;
                case 0:return;
            }
        }
    }
}
