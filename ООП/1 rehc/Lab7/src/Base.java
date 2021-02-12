public class Base {
	static int people_on_base=100;
	static int vehicles_on_base=0;
	static double petrol_on_base=400;
	static double goods_on_base=400;
	static void info() {
		System.out.println("\nКол-во людей на базе: "+people_on_base+" чел.\nКол-во трансп. средств на базе: "+vehicles_on_base+" ед.\nКол-во топлива на базе: "+petrol_on_base+" л.\nКол-во груза на базе: "+goods_on_base+" т.");
	}
}