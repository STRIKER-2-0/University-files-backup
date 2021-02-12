package lab4;

public class Truck extends Vehicle {
	private double load, max_load;

	Truck(double load, double max_load, double petrol_amount, double tank_volume){
		super(petrol_amount, tank_volume);
		if((petrol_amount<=tank_volume)&&(load<=max_load)&&(petrol_amount>0)&&(tank_volume>0)&&(load>=0)&&(max_load>=0)) {
			this.petrol_amount=petrol_amount;
			this.tank_volume=tank_volume;
			this.load=load;
			this.max_load=max_load;
		}
		else { 
			System.out.println("Некорректные параметры трансп. средства! Будет установлен стандарт.");
			this.petrol_amount=100;
			this.tank_volume=100;
			this.load=0;
			this.max_load=100;
		}
	}
	double getCurrentLoad() {
		return load;
	}
	double getMaxLoad() {
		return max_load;
	}
	@Override
	void arrive() {
		if(position==false) {
			Base.people_on_base++;
			Base.vehicles_on_base++;
			Base.goods_on_base+=load;
			load=0;
			position=true;
		}
		else System.out.println("Трансп. средство уже на базе!");
	}
	@Override
	boolean leave() {
		if(position==true) {
			if((Base.people_on_base>=1)&&(Base.petrol_on_base>=tank_volume)) {
				Base.people_on_base--;
				Base.vehicles_on_base--;
				Base.petrol_on_base-=(tank_volume-petrol_amount);
				petrol_amount=tank_volume;
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
			return false;
		}
		else {
			System.out.println("Трансп. средство еще не на базе!");
			return true;
		}
	}	
}
