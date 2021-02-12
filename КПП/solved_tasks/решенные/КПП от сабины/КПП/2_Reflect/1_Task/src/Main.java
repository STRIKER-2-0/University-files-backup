import java.beans.beancontext.BeanContextServiceRevokedEvent;
import java.lang.reflect.Array;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int menu=-1;
        Object arr=null;
        Scanner sc=new Scanner(System.in);
        String clsS=null;
        int[] size=null;

        while(true){
            System.out.println("1-Задать массив");
            System.out.println("2-Изменить размер");
            System.out.println("3-Задать значения");
            System.out.println("4-Вывести в строку");
            System.out.println("0-Выход");
            do {
                try {
                    menu = sc.nextInt();
                    if(menu<0||menu>4) System.out.println("Нет такого номера, повторите ввод");
                    else sc.nextLine();
                }catch (InputMismatchException e){
                    sc.nextLine();
                    System.out.println("Некорректный ввод, повторите ввод");
                }
            }while (menu<0||menu>4);
            switch (menu){
                case 1:
                    try {
                        System.out.println("Введите массив и размерность(н-р:int[2][2])");
                        clsS=sc.nextLine();
                        size=CrafterClass.getSize(clsS);
                        arr= Array.newInstance(CrafterClass.getType(clsS),size);
                    } catch (ClassNotFoundException e) {
//                  e.printStackTrace();
                        System.out.println("Класс не найден");
                    }
                    break;
                case 2:
                    if(arr==null){
                        System.out.println("Массив не задан");
                        break;
                    }
                    int[] newsize = new int[size.length];
                    for (int i = 0; i < newsize.length; i++) {
                        System.out.println("Введите размерность " + i  + "-го измерения");
                        do {
                            try {
                                newsize[i] = sc.nextInt();
                                if (newsize[i] < 1 || newsize[i] > 1000)
                                    System.out.println("Недопустимая размерность, повторите ввод");
                            } catch (InputMismatchException e) {
                                sc.nextLine();
                                System.out.println("Некорректный ввод, повторите ввод");
                            }
                        } while (newsize[i] < 1 || newsize[i] > 1000);
                    }
                    try {
                        arr = CrafterClass.changeSize(arr, clsS, newsize,size);
                        size=newsize;
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    if(arr==null){
                        System.out.println("Массив не задан");
                        break;
                    }
                    CrafterClass.fill(arr,size,0);
                    break;
                case 4:
                    if(arr==null){
                        System.out.println("Массив не задан");
                        break;
                    }
                    System.out.print("{");
                    CrafterClass.print(arr,size,0);
                    System.out.println("}");
                    break;
                case 0:return;
            }
        }
    }
}
