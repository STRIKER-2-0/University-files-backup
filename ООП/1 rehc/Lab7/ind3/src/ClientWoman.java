public class ClientWoman extends Barber{
	private String haircut;
	protected boolean gender=false;
	
	ClientWoman(){
		this.lastname="�������";
		this.firstname="�����";
		this.patronimic="����������";
		this.old=25;
		this.haircut="��������";
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
		System.out.println("\n��� ��������: "+haircut);
	}
	
}
