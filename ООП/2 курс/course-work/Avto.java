
public class Avto extends Vehicle{
	
	Avto(){
		type=Type.AVTO;
		name="Some_car";
		year=2000;
		model=new Model();
		model.name="any_model";
		model.num=3;
		manufacturer="Cars&Motos";
		petrolType=PetrolType.GAS;		
		capacity=1000;
		cost=20000;
	}
	Avto(String name, Model model,  int year, String manufacturer, PetrolType petrolType, double capacity, double cost){
		type=Type.AVTO;
		this.name=name;
		this.year=year;
		model=new Model();
		this.model.name=model.name;
		this.model.num=model.num;
		this.manufacturer=manufacturer;
		this.petrolType=petrolType;
		this.capacity=capacity;
		this.cost=cost;
	}	
}
