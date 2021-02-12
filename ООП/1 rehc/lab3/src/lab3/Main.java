package lab3;
import java.util.*;
import java.lang.Thread;	//для сна
public class Main {
	public static void main(String ags[])throws InterruptedException {	//для сна
		Scanner scan=new Scanner(System.in);
		int ans,val;
		double[] arr=new double[5];
		for(int i=0; i< arr.length; i++)
			arr[i]=(int)(Math.random()*10);
		Vector vk=new Vector(arr);		
		
		System.out.println("Объект vector создан! Выберите дальнейшие действия: ");
		while(true) {
			Thread.sleep(1500);	//сон две секунды
			System.out.println("\n1.Получить текущий размер\n2.Получить значение из ячейки\n3.Заменить элемент\n4.Добавить элемент\n5.Удалить элемент\n6.Очистить массив\n7.Распечатать массив\n8.Создать клона\n9.Выход");
			ans=scan.nextInt();
			switch(ans) {
				case 1: System.out.println("Текущий размер: "+vk.getSize()); break;
				case 2: System.out.print("Введите номер ячейки: "); 
						ans=scan.nextInt();
						System.out.println("Значение в ячейке: "+vk.get(ans));
						break;
				case 3: System.out.print("Введите номер ячейки: "); 
						ans=scan.nextInt();
						System.out.print("Введите значение: "); 
						val=scan.nextInt();
						vk.set(val, ans);
						break;
				case 4: System.out.print("Введите номер ячейки: "); 
						ans=scan.nextInt();
						System.out.print("Введите значение: "); 
						val=scan.nextInt();
						vk.insert(val, ans);
						break;
				case 5: System.out.print("Введите номер ячейки: "); 
						ans=scan.nextInt();
						vk.erase(ans);
						break;
				case 6: vk.clear(); break;
				case 7: vk.print(); break;
				case 8: Vector b=vk.Clone(); System.out.println("Клон создан!!"); Clone(scan,b); break;
				case 9: System.out.println("---Конец теста---"); scan.close(); return;
				default: System.out.println("Некорректные данные!");
			}
		}		
		
	}
	public static void Clone(Scanner scan, Vector vk)throws InterruptedException {
		int ans,val;
		System.out.println("---Работа с клоном---");
		while(true) {
			Thread.sleep(1500);	//сон две секунды
			System.out.println("\n1.Получить текущий размер\n2.Получить значение из ячейки\n3.Заменить элемент\n4.Добавить элемент\n5.Удалить элемент\n6.Очистить массив\n7.Распечатать массив\n8.Создать клона\n9.Выход");
			ans=scan.nextInt();
			switch(ans) {
				case 1: System.out.println("Текущий размер: "+vk.getSize()); break;
				case 2: System.out.print("Введите номер ячейки: "); 
						ans=scan.nextInt();
						System.out.println("Значение в ячейке: "+vk.get(ans));
						break;
				case 3: System.out.print("Введите номер ячейки: "); 
						ans=scan.nextInt();
						System.out.print("Введите значение: "); 
						val=scan.nextInt();
						vk.set(val, ans);
						break;
				case 4: System.out.print("Введите номер ячейки: "); 
						ans=scan.nextInt();
						System.out.print("Введите значение: "); 
						val=scan.nextInt();
						vk.insert(val, ans);
						break;
				case 5: System.out.print("Введите номер ячейки: "); 
						ans=scan.nextInt();
						vk.erase(ans);
						break;
				case 6: vk.clear(); break;
				case 7: vk.print(); break;
				case 8: Vector b=vk.Clone(); System.out.println("Клон создан!!"); Clone(scan,b); break;
				case 9: System.out.println("---Возврат к предыдущему объекту---");  return;
				default: System.out.println("Некорректные данные!");
			}
		}
	}
}
