
public class Truck extends Vehicle implements ITruck{
	private double load, max_load;

	Truck(double load, double max_load, double petrol_amount, double tank_volume){
		super(petrol_amount, tank_volume);
		if((load<=max_load)&&(load>=0)&&(max_load>=0)) {			
			this.load=load;
			this.max_load=max_load;
		}
		else { 
			System.out.println("Некорректные параметры трансп. средства! Будет установлен стандарт.");			
			this.load=0;
			this.max_load=100;
		}
	}
	public double getCurrentLoad() {
		return load;
	}
	public double getMaxLoad() {
		return max_load;
	}
	@Override
	public void arrive() {
		super.arrive();			
		Base.goods_on_base+=load;
		load=0;
		position=true;
		
	}
	@Override
	public boolean leave() {
		if(position==true) {
			if(super.leave()) {
				if(Base.goods_on_base>=max_load) {
					Base.goods_on_base-=max_load;
					load=max_load;					
				}
				else {
					load=Base.goods_on_base;
					Base.goods_on_base=0;					
				}
				position=false;
				return true;
			}
			else return false;
		}
		else {
			//System.out.println("Трансп. средство еще не на базе!");
			return true;
		}
	}	
}