//программа не предназначена для пользователя. Вся суть класса Main в тесте объекта Stakan
import java.util.*;

public class Main {
	public static void main(String ags[]) {		
		Scanner scan=new Scanner(System.in);
		float value;	//значение для считывания
		Stakan stak=new Stakan();	//тест - обычный объект(пустой конструктор)
		//тест методов get
		System.out.print("Объект создан с обычными параметрами:\nПроверка возможностей объекта:\nПроверка параметров с помощью методов get:\n");
		System.out.println("Масса: "+stak.getMass()+"g");
		System.out.println("Объем: "+stak.getVolume()+"ml");
		System.out.println("Содержимое: "+stak.getContent()+"ml");
		System.out.println("Установка новых параметров с помощью методов set:");
		//тест методов set
		do{
			System.out.println("Введите массу: ");
			value=scan.nextFloat();
			if(stak.setMass(value))
				System.out.println("Масса установлена");
			else
				System.out.println("Ошибка установки");
		}while(!stak.setMass(value));
		
		do{
			System.out.println("Введите объем: ");
			value=scan.nextFloat();
			if(stak.setVolume(value))
				System.out.println("Объем установлен");
			else
				System.out.println("Ошибка установки");
		}while(!stak.setVolume(value));
		
		do{
			System.out.println("Введите содержимое: ");
			value=scan.nextFloat();
			if(stak.setContent(value))
				System.out.println("Содержимое установлено");
			else
				System.out.println("Ошибка установки");
		}while(!stak.setContent(value));
		
		//тест методa print
		System.out.println("Печать всех данных с помошью метода print: ");
		stak.print();
		//объект с параметрами(методы отдельно не проверял, только принт)
		stak=new Stakan(30,-6);
		System.out.print("\nОбъект создан с дополнительными параметрами:\n");
		stak.print();		
		
		//массив стаканов
		Stakan[] stakans;
		stakans=new Stakan[5];
		for(int i=0; i<stakans.length; i++)
			stakans[i]=new Stakan();
		System.out.print("\nМассив объектов:\n");
		for(int i=0; i<stakans.length; i++)
			stakans[i].print();
		
		//номер элемента - большой цикл
		int ans=1;
		while(ans!=0) {	
			System.out.println("\nВозможность изменения любого элемента массива: Введите номер элемента:");
			int num=scan.nextInt();
			while((num<0)||(num>4)) {//проверка на правильность номера
				System.out.println("Несуществующий элемент!!");
				num=scan.nextInt();
			}
			
			//тут реализовано меню для удобства управления элементами
			System.out.println("\nДействия с объектом:\n1.Получить характеристику(get)\n2.Установить характеристику(set)\n3.Показать текущие характеристики(print)\n0.Завершить тест");
			ans=scan.nextInt();
			switch(ans) {
			case 1: getch(stakans,num,scan); break;	//для того, что бы не перегружать мейн лишними операциями, сделаны отдельные функции
			case 2: setch(stakans,num,scan);break;
			case 3: stakans[num].print(); break;
			case 0: scan.close(); System.out.print("---конец теста---"); return; //ноль что бы прекратить
			default: System.out.print("Некорректное значение!!\n");
			}
		}
		scan.close();
	}
	//функция для get-ов
	public static void getch(Stakan[] stakans, int num, Scanner scan) {
		System.out.println("\nДействия с объектом:\n1.Получить Массу\n2.Получить объем\n3.Получить содержимое\n0.Вернуться в предыдущее меню");
		int ans=scan.nextInt();
		switch(ans) {
		case 1: System.out.println("Масса: "+stakans[num].getMass()); break;
		case 2: System.out.println("Объём: "+stakans[num].getVolume()); break;
		case 3: System.out.println("Содержимое: "+stakans[num].getContent()); break;
		case 0: return;
		default: System.out.print("Некорректное значение!!\n");
		}
	}
	//функция для set-ов
	public static void setch(Stakan[] stakans, int num, Scanner scan) {
		System.out.println("\nДействия с объектом:\n1.Установить массу\n2.Установить объем\n3.Установить содержимое\n0.Вернуться в предыдущее меню");
		int ans=scan.nextInt();
		float value;
		switch(ans) {
		case 1: do{
			System.out.println("Введите массу: ");
			value=scan.nextFloat();
			if(stakans[num].setMass(value))
				System.out.println("Масса установлена");
			else
				System.out.println("Ошибка установки");
		}while(!stakans[num].setMass(value)); break;
		case 2: do{
			System.out.println("Введите объем: ");
			value=scan.nextFloat();
			if(stakans[num].setVolume(value))
				System.out.println("Объем установлена");
			else
				System.out.println("Ошибка установки");
		}while(!stakans[num].setVolume(value)); break;
		case 3: do{
			System.out.println("Введите содержимое: ");
			value=scan.nextFloat();
			if(stakans[num].setContent(value))
				System.out.println("Содержимое установлено");
			else
				System.out.println("Ошибка установки");
		}while(!stakans[num].setContent(value)); break;
		case 0: return;
		default: System.out.print("Некорректное значение!!\n");
		}
	}
}