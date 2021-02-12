
public class Bus extends Vehicle implements IBus{
	private int people,max_people;
	
	Bus(int people, int max_people,double petrol_amount, double tank_volume){
		super(petrol_amount, tank_volume);
		if((people<=max_people)&&(people>=0)&&(max_people>=0)) {			
			this.people=people;
			this.max_people=max_people;
		}
		else { 
			System.out.println("Некорректные параметры трансп. средства! Будет установлен стандарт.");
			this.people=0;
			this.max_people=100;
		}
	}
	public int getPeopleCount() {
		return people;
	}
	public int getMaxPeople() {
		return max_people;
	}	
	@Override
	public void arrive() {
		super.arrive();
		Base.people_on_base+=people;			
		people=0;
		position=true;
		
	}
	@Override
	public boolean leave() {
		if(position==true) {
			if(super.leave()) {
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
			else return false;
		}
		else {
			System.out.println("Трансп. средство еще не на базе!");
			return false;
		}
	}	
}