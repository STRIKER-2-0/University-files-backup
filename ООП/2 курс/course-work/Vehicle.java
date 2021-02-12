import java.io.Serializable;

public abstract class Vehicle implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7563157647819939297L;
	protected Type type;
	protected String name;
	protected Model model;
	protected int year;
	protected String manufacturer;
	protected PetrolType petrolType;
	protected double capacity;
	protected double cost;
	
	/*
	public void setType(Type type) {
    	this.type=type;
    }*/
    public Type getType() {
    	return type;
    }    
    public void setName(String name) {
    	this.name=name;
    }
    public String getName() {
    	return name;
    }       
    public void setModel(Model model) {
    	this.model=model;
    }
    public Model getModel() {
    	return model;
    }
    public void setYear(int year) {
    	this.year=year;
    }
    public int getYear() {
    	return year;
    } 
    public void setManufacturer(String manufacturer) {
    	this.manufacturer=manufacturer;
    }
    public String getManufacturer() {
    	return manufacturer;
    }   
    public void setPetrolType(PetrolType petrolType) {
    	this.petrolType=petrolType;
    }
    public PetrolType getPetrolType() {
    	return petrolType;
    }
    public void setTankCapacity(double capacity) {
    	this.capacity=capacity;
    }
    public double getTankCapacity() {
    	return capacity;
    }    
    public void setCost(double cost) {
    	this.cost=cost;
    }
    public double getCost() {
    	return cost;
    }
    @Override
    public boolean equals(Object obj) {
    	// TODO Auto-generated method stub
    	if(super.equals(obj)==true) return true;
    	if(type!=((Vehicle) obj).getType()) return false;
    	if(!name.equals(((Vehicle) obj).getName())) return false;
    	if(!model.name.equals(((Vehicle) obj).getModel().name)) return false;
    	if(model.num!=((Vehicle) obj).getModel().num) return false;
    	if(year!=((Vehicle) obj).getYear()) return false;
    	if(!manufacturer.equals(((Vehicle) obj).getManufacturer())) return false;
    	if(petrolType!=((Vehicle) obj).getPetrolType()) return false;
    	if(capacity!=((Vehicle) obj).getTankCapacity()) return false;
    	if(cost!=((Vehicle) obj).getCost()) return false;
    	else return true;
    }
}
