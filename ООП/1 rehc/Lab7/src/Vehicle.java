
public class Vehicle implements IVehicle{
	protected boolean position=false;	//местонахождение машины	
	protected double petrol_amount, tank_volume;	//параметры машины
	
	Vehicle(double petrol_amount, double tank_volume){
		if((petrol_amount<=tank_volume)&&(petrol_amount>0)&&(tank_volume>0)) {
			this.petrol_amount=petrol_amount;
			this.tank_volume=tank_volume;
		}
		else { 
			System.out.println("Некорректные параметры трансп. средства! Будет установлен стандарт.");
			this.petrol_amount=100;
			this.tank_volume=100;
		}
	}
	public double getTankVolume() {
		return tank_volume;
	}
	public double getPetrolAmount() {
		return petrol_amount;
	}
	public void arrive() {
		if(position==false) {
			Base.people_on_base++;
			Base.vehicles_on_base++;
			position=true;
		}
		else System.out.println("Трансп. средство уже на базе!");
	}
	public boolean leave() {
		if(position==true) {			
			if((Base.people_on_base>=1)&&(Base.petrol_on_base>=(tank_volume-petrol_amount))&&(Base.vehicles_on_base>=1)) {
				Base.people_on_base--;
				Base.vehicles_on_base--;
				Base.petrol_on_base-=(tank_volume-petrol_amount);
				petrol_amount=tank_volume;
				position=false;
				return true;
			}
			return false;
		}
		else {
			System.out.println("Трансп. средство еще не на базе!");
			return false;
		}
	}
}