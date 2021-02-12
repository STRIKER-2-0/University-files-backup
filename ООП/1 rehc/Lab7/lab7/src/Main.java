public class Main {
	public static void main(String ars[]){
		Expeditor ex=new Expeditor(10,20,20,40,50,100);
		Base.info();
		ex.info();
		
		ex.arrive();
		Base.info();
		ex.info();
		
		ex.leave();
		Base.info();
		ex.info();
	}
}





