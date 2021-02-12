public class ClientMan extends Barber{
	private int hairLength;
	
	ClientMan(){
		this.lastname="Иванов";
		this.firstname="Иван";
		this.patronimic="Иванович";
		this.old=30;
		this.hairLength=10;
	}
	ClientMan(String lastname, String firstname, String patronimic, int old, int hairLength){
		if((old>=0)&&(hairLength>=0)){
			this.old=old;
			this.hairLength=hairLength;
		}
		else{
			this.old=30;
			this.hairLength=10;
		}
		this.lastname=lastname;
		this.firstname=firstname;
		this.patronimic=patronimic;
	}
	public int getHairLength(){
		return hairLength;
	}
	public boolean setHairLength(int hairLength){
		if(hairLength>=0){
			this.hairLength=hairLength;
			return true;
		}
		else return false;
	}
	public void info(){
		super.info();
		System.out.println("\nДлинна прически: "+hairLength);
	}
	
}