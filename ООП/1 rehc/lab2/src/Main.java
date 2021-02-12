import java.util.*;
public class Main {
	public static void main(String ags[]) {		
		Scanner scan=new Scanner(System.in);
		float value;
		Stakan stak=new Stakan();
		System.out.print("Объект создан с обычными параметрами:\nПроверка возможностей объекта:\n1.Проверка параметров с помощью методов get:\n");
		System.out.println("Масса: "+stak.getMass()+"g");
		System.out.println("Объем: "+stak.getVolume()+"ml");
		System.out.println("Содержимое: "+stak.getContent()+"ml");
		System.out.println("Установка новых параметров с помощью методов set:");
		
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
					
		System.out.println("Печать всех данных с помошью метода print: ");
		stak.print();
		
		stak=new Stakan(30,6);
		System.out.print("Объект создан с дополнительными параметрами:\n");
		stak.print();
		
	}
}
