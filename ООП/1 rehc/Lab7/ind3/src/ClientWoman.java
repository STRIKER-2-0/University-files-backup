public class ClientWoman extends Barber{
	private String haircut;
	protected boolean gender=false;
	
	ClientWoman(){
		this.lastname="Иванова";
		this.firstname="Дарья";
		this.patronimic="Николаевна";
		this.old=25;
		this.haircut="Вечерняя";
	}
	ClientWoman(String lastname, String firstname, String patronimic, int old, String haircut){
		if((old>=0)){
			this.old=old;
		}
		else{
			this.old=30;
		}
		this.lastname=lastname;
		this.firstname=firstname;
		this.patronimic=patronimic;
		this.haircut=haircut;
	}
	
	@Override	
	public boolean getGender() {
		return this.gender;
	}
	public String getHairCut(){
		return haircut;
	}
	public void setHairCut(String haircut){
		this.haircut=haircut;
	}
	public void info(){
		super.info();
		System.out.println("\nТип прически: "+haircut);
	}
	
}
