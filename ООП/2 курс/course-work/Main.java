import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main{
    public static void main(String []args){
    	Shop shop=new Shop("Autoshop", "13 Baker st.");	//магазин
    	Scanner s=new Scanner(System.in);
    	Map<Client, Vehicle> Sells = new HashMap<>();	//МАР для хранения продаж
    	int ans=0;
    	
    	while (true) {
    		System.out.println("1. Додати транспортний засіб до реєстру");
    		System.out.println("2. Видалити транспортний засіб із реєстру");
    		System.out.println("3. Отримати список усіх транспортних засобів, що містяться у реєстрі");
    		System.out.println("4. Отримати список усіх транспортних засобів, тип палива яких відповідає заданому");
    		System.out.println("5. Продати обране авто покупцеві магазину, при цьому транспортний засіб	видаляється із реєстру та записується ціна продажу");
    		System.out.println("6. Роздрукувати суму продажів за «день»");
    		System.out.println("7. Зберегти реєстр до сховища (текстовий файл)");
    		System.out.println("8. Отримати реєстр із сховища (текстового файлу)");
    		System.out.println("9. Вихід");
    		ans=(int)valid(s);
    		switch (ans) {
			case 1:
				shop.add(temp_vehicle());
				break;
			case 2:
				shop.delete(temp_vehicle());
				break;
			case 3:				
				for (Vehicle v : shop.getRegistry()) {
					System.out.println(v.getType().name()+" "+v.getName()+" "+v.getModel().name+"-"+v.getModel().num+" "+v.getYear()+" "+v.getManufacturer()+" "+v.getPetrolType().name()+" "+v.getTankCapacity()+" "+v.getCost());
				}
				break;
			case 4:
				PetrolType temp;
				while (true) {
					System.out.println("Оберіть тип палива: \n1. Бензин \n2. Дизель \n3. Електрокар \n4. Ядерний");    		
		    		ans=(int)valid(s);
		    		switch (ans) {
					case 1:
						temp=PetrolType.GAS;
						break;
					case 2:
						temp=PetrolType.DIEZEL;
						break;
					case 3:
						temp=PetrolType.ELECTRIC;
						break;
					case 4:
						temp=PetrolType.NUCLEAR;
						break;
					default:
						System.out.println("---Uncorrect input---");
						continue;
					}
		    		break;
				}
				for (Vehicle v : shop.getPetrolRegistry(temp)) {
					System.out.println(v.getType().name()+" "+v.getName()+" "+v.getModel().name+v.getModel().num+" "+v.getYear()+" "+v.getManufacturer()+" "+v.getPetrolType().name()+" "+v.getTankCapacity()+" "+v.getCost());
				}
				break;
			case 5:		//транзакция
				Client client = new Client();
				System.out.print("Введіть дані покупця: \nІм'я:");
				client.setName(s.next());
				System.out.print("Прізвище: ");
				client.setSurname(s.next());
				System.out.println("Рік народження: ");
				client.setYear((int)valid(s));
				System.out.println("Ідентифікаційний код: ");
				client.setID((long)valid(s));
				System.out.println("Опишіть транспортний засіб, який шукає покупець: ");
				Vehicle purchase = shop.sellVehicle(temp_vehicle());
				
				if(purchase!=null) {
					Sells.put(client, purchase);
					System.out.println("Продаж відбувся!");
				}
				else {
					System.out.println("На жаль, транспортного засобу, який шукає покупець, не знайдно в реєстрі");
				}
				break;
			case 6: 
				for (Client c : Sells.keySet()) {
					System.out.println(c.getName()+": "+Sells.get(c).getName()+" "+Sells.get(c).getCost());
				}
				System.out.println("Прибуток за день: "+shop.getBank()); 
				break;
			case 7:
				try {
					shop.upload();
					System.out.println("Дані вигружено до сховища!");
				} catch (IOException e) {
					System.out.println("Файл не знайдено!");
				}
				break;
			case 8:
				try {
					shop.download();
					System.out.println("Дані загружено зі сховища!");
				} catch (IOException e) {
					System.out.println("Файл не знайдено!");
				}
				break;
			case 9:
				try {
					shop.upload();
					System.out.println("Дані вигружено до сховища!");
				} catch (IOException e) {
					System.out.println("Файл не знайдено!");
				}
				s.close();
				System.out.println("---end---");
				return;
			default:
				System.out.println("---Uncorrect input---");
				break;
			}
		}
    	
    }
  //функция выбора абстракции. тоесть в ней мы "собираем" машину, с которой хотим работать
    //будь то удаление, добавление, поиск. Абстракцию формируем тут
    public static Vehicle temp_vehicle() { 		
    	int ans; 
    	Scanner s=new Scanner(System.in);
    	Vehicle v;		
		
    	while (true) {
			System.out.println("Оберіть тип транспортного засобу: 1. Автомобіль 2. Мотоцикл");    		
    		ans=(int)valid(s);
    		switch (ans) {
			case 1:
				v=new Avto();
				break;
			case 2:
				v=new Moto();
				break;
			default:
				System.out.println("---Uncorrect input---");
				continue;
			}
    		break;
		}
		System.out.print("Введіть назву транспортного засобу: ");    		
		v.setName(s.next());
		System.out.print("Введіть модель транспортного засобу: ");    		
		String tmp=s.next();
		System.out.print("	номер моделі: ");    		
		v.setModel(new Model(tmp, (int)valid(s)));
		System.out.print("Введіть рік виробництва транспортного засобу: ");    		
		v.setYear((int)valid(s));
		System.out.print("Введіть виробника: ");    		
		v.setManufacturer((s.next()));
		while (true) {
			System.out.println("Оберіть тип палива: \n1. Бензин \n2. Дизель \n3. Електрокар \n4. Ядерний");    		
    		ans=(int)valid(s);
    		switch (ans) {
			case 1:
				v.setPetrolType(PetrolType.GAS);
				break;
			case 2:
				v.setPetrolType(PetrolType.DIEZEL);
				break;
			case 3:
				v.setPetrolType(PetrolType.ELECTRIC);
				break;
			case 4:
				v.setPetrolType(PetrolType.NUCLEAR);
				break;
			default:
				System.out.println("---Uncorrect input---");
				continue;
			}
    		break;
		}
		System.out.print("Введіть ємність паливного сховища: ");    		
		v.setTankCapacity(valid(s));
		System.out.print("Введіть ціну: ");    		
		v.setCost(valid(s));
		//s.close();
    	return v;
	}
    public static double valid(Scanner s) {
    	double ans;
    	while(true) {
			try {
				ans=s.nextDouble();
				break;
			}catch(Exception e) {
				System.out.println("---Uncorrect input---");
				s.next();
			}
		}
    	return ans;
    }

}
