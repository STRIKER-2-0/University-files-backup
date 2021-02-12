package lab4;

public class Bus extends Vehicle{
	private int people,max_people;
	
	Bus(int people, int max_people,double petrol_amount, double tank_volume){
		super(petrol_amount, tank_volume);
		if((petrol_amount<=tank_volume)&&(people<=max_people)&&(petrol_amount>0)&&(tank_volume>0)&&(people>=0)&&(max_people>=0)) {
			this.petrol_amount=petrol_amount;
			this.tank_volume=tank_volume;
			this.people=people;
			this.max_people=max_people;
		}
		else { 
			System.out.println("Некорректные параметры трансп. средства! Будет установлен стандарт.");
			this.petrol_amount=100;
			this.tank_volume=100;
			this.people=0;
			this.max_people=100;
		}
	}
	int getPeopleCount() {
		return people;
	}
	int getMaxPeople() {
		return max_people;
	}	
	@Override
	void arrive() {
		if(position==false) {
			Base.people_on_base+=people+1;
			Base.vehicles_on_base++;
			people=0;
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
				if(Base.people_on_base>=max_people) {
					Base.people_on_base-=max_people;
					people=max_people;
				}
				else {
					people=Base.people_on_base;
					Base.people_on_base=0;
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
