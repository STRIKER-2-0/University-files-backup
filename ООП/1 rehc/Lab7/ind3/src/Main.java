
import java.util.Scanner;


public class Main{
    static Scanner scan=new Scanner(System.in);
    static Vector list=new Vector();
    public static void main(String ags[]){     
        int ans;
        String str;
        ClientMan man;
        ClientWoman woman;
               
        System.out.println("---Каталог клиентов парикмахерской---");
        while(true) {
            System.out.println("1.Простотр всего содержимого каталога\n2.Добавить новый элемент\n3.Удалить элемент\n4.Редактировать элемент\n5.Поиск по каталогу\n6.Выход");
            ans=scan.nextInt();
            switch(ans) {
            case 1: list.print(); break;
            case 2: System.out.print("Укажите пол клиента: 1.Мужской 2.Женский  ");
                    ans=scan.nextInt();
                    if(ans==1) {
                        man=new ClientMan();
                        System.out.println("Введите данные клиента:\nФамилия: ");
                        str=scan.next();
                        man.setLastname(str);
                        System.out.println("\nИмя: ");
                        str=scan.next();
                        man.setFirstname(str);
                        System.out.println("\nОтчество: ");
                        str=scan.next();
                        man.setPatronimic(str);
                        System.out.println("\nВозраст: ");
                        ans=scan.nextInt();
                        man.setOld(ans);
                        System.out.println("\nДлинна стрижки: ");
                        ans=scan.nextInt();
                        if(!man.setHairLength(ans))
                            System.out.println("\nНекорректный параметр!");
                        System.out.println("Введите позицию: ");
                        ans=scan.nextInt();
                        list.insert(man, ans);
                    }
                    else if(ans==2){
                        woman=new ClientWoman();                       
                        System.out.println("\nВведите данные клиента:\nФамилия: ");
                        str=scan.next();
                        woman.setLastname(str);
                        System.out.println("\nИмя: ");
                        str=scan.next();
                        woman.setFirstname(str);
                        System.out.println("\nОтчество: ");
                        str=scan.next();
                        woman.setPatronimic(str);
                        System.out.println("\nВозраст: ");
                        ans=scan.nextInt();
                        woman.setOld(ans);
                        System.out.println("\nТип стрижки: ");
                        str=scan.next();
                        woman.setHairCut(str);
                        System.out.println("Введите позицию: ");
                        ans=scan.nextInt();
                        list.insert(woman, ans);
                    }
                    else {
                        System.out.println("Введены неверные данные.");
                        break;
                    }    
                    break;
            case 3: System.out.println("Введите позицию для удаления: ");
                    ans=scan.nextInt();
                    list.erase(ans);
                    break;
            case 4: if(list.getSize()>0)
            			edit();
            		else
            			System.out.println("Вектор пуст!");
                    break;
            case 5: if(list.getSize()>0)
            			searchmenu();
            		else
            			System.out.println("Вектор пуст!");
            		break;
            case 6: System.out.println("---Тест окончен---"); scan.close(); return;
            default: System.out.println("Введено неверное значение! Повторите попытку.");
            }
        }
    }
    public static void edit() {
        int pos,ans=0,tmp;
        String str;
        ClientMan man;
        ClientWoman woman;
       
        System.out.println("Введите позицию для редактирования: ");
        tmp=scan.nextInt();
        if(tmp<list.getSize()) {
            System.out.print("Что вы желаете редактировать:\n1.Фамилию\n2.Имя\n3.Отчество\n4.Возраст");
            if(list.get(tmp).getGender())
                System.out.println("\n5.Длинну стрижки\n6.Назад");
            else
                System.out.println("\n5.Тип стрижки\n6.Назад");
            ans=scan.nextInt();
            switch(ans) {
            case 1: System.out.print("Введите новую фамилию: ");
                    str=scan.next();
                    list.get(tmp).setLastname(str);
                    break;
            case 2: System.out.print("\nВведите новое имя: ");
                    str=scan.next();
                    list.get(tmp).setFirstname(str);
                    break;
            case 3: System.out.print("\nВведите новое отчество: ");
                    str=scan.next();
                    list.get(tmp).setPatronimic(str);
                    break;
            case 4: System.out.print("\nВведите новый возраст: ");
                    pos=scan.nextInt();                
                    list.get(tmp).setOld(pos);
                    break;
            case 5: if(list.get(tmp).getGender()) {
                        System.out.print("\nВведите длинну стрижки: ");
                        pos=scan.nextInt();
                        man=new ClientMan();
                        man.setLastname(list.get(tmp).getLastname());
                        man.setFirstname(list.get(tmp).getFirstname());
                        man.setPatronimic(list.get(tmp).getPatronimic());
                        man.setOld(list.get(tmp).getOld());
                        man.setHairLength(pos);
                        list.set(man, tmp);
                    }
                    else {
                        System.out.print("\nВведите тип стрижки: ");
                        str=scan.next();
                        woman=new ClientWoman();
                        woman.setLastname(list.get(tmp).getLastname());
                        woman.setFirstname(list.get(tmp).getFirstname());
                        woman.setPatronimic(list.get(tmp).getPatronimic());
                        woman.setOld(list.get(tmp).getOld());
                        woman.setHairCut(str);
                        list.set(woman, tmp);
                    }
                    break;
            case 6: System.out.println("---Возврат---"); return;
            default: System.out.println("Введено неверное значение");
            }
        }
        else
            System.out.println("Введены неверные данные.");
    }
    static void searchmenu(){
    	boolean flag=false;
        String str;
        System.out.println("Выберите критерий поиска:\n1.Поиск по фамилии\n2.Поиск по возрасту\n3.Поиск по номеру\n4.Вывести всех клиентов\n5.Вывести всех клиенток\n6.Назад");
        int ans=scan.nextInt();
        switch(ans){
            case 1:
                System.out.println("Введите фамилию: ");
                str=scan.next();
                for(int i=0; i<list.getSize(); i++){
                    if(str.equals(list.get(i).getLastname())) {
                        list.get(i).info();
                        flag=true;
                    }
                }
                if(flag==false)
                	System.out.println("Клиенты не найдены!");
                else
                	System.out.println();
                break;
            case 2:
                System.out.print("Введите возраст: ");
                ans=scan.nextInt();
                for(int i=0; i<list.getSize(); i++){
                    if(list.get(i).getOld()==ans) {
                        list.get(i).info();
                        flag=true;
                    }
                }
                if(flag==false)
                	System.out.println("Клиенты не найдены!");
                else
                   	System.out.println();
                break;
            case 3:
                System.out.print("Введите номер: ");
                ans=scan.nextInt();
                if((ans>=0)&&(ans<list.getSize()))
                    list.get(ans).info();
                else
                    System.out.println("Неверное значение номера!");
                System.out.println();
                break;
            case 4:
                System.out.println("Список клиентов-мужчин: ");
                for(int i=0; i<list.getSize(); i++){
                    if(list.get(i).getGender())
                        list.get(i).info();
                }
                System.out.println();
                break;
            case 5:
                System.out.println("Список клиентов-женщин: ");
                for(int i=0; i<list.getSize(); i++){
                    if(!list.get(i).getGender())
                        list.get(i).info();
                }
                System.out.println();
                break;
            case 6: System.out.println("---Возврат---"); return;
            default: System.out.println("Введено неверное значение");
        }
    }
}