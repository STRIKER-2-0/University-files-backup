

public class Expeditor implements IExpeditor{
	private Truck truck;
	private Bus bus;
	
	Expeditor(double petrol_amount, double tank_volume, int people, int max_people, double load, double max_load){
		bus=new Bus(people, max_people, petrol_amount/2, tank_volume/2);
		truck=new Truck(load, max_load, petrol_amount-petrol_amount/2, tank_volume-tank_volume/2);
	}
	public double getTankVolume() {
		return bus.getTankVolume()+truck.getTankVolume();
	}
	public double getPetrolAmount() {
		return bus.getPetrolAmount()+truck.getPetrolAmount();
	}
	public int getPeopleCount() {
		return bus.getPeopleCount();
	}
	public int getMaxPeople() {
		return bus.getMaxPeople();
	}
	public double getCurrentLoad() {
		return truck.getCurrentLoad();
	}
	public double getMaxLoad() {
		return truck.getMaxLoad();
	}
	public void arrive() {
		bus.arrive();
		truck.arrive();
		if(bus.position&&truck.position) {
			Base.people_on_base--;
			Base.vehicles_on_base--;
		}
	}
	public boolean leave() {
		if(Base.petrol_on_base>=(bus.getPetrolAmount()-bus.getPeopleCount())*2) {
			if(bus.leave()) {
				Base.people_on_base++;
				Base.vehicles_on_base++;
			}
			truck.leave();
			if(!bus.position&&!truck.position) {
				return true;
			}
			else return false;
		}
		return false;
	}
	public void info() {
		System.out.println("\nТопливо: "+(bus.getPetrolAmount()+truck.getPetrolAmount())+"/"+(bus.getTankVolume()+truck.getTankVolume()));
		System.out.println("Пассажиры: "+bus.getPeopleCount()+"/"+bus.getMaxPeople());
		System.out.println("Груз: "+truck.getCurrentLoad()+"/"+truck.getMaxLoad());
	}
}

