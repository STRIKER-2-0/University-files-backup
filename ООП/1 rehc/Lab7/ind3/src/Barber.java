public abstract class Barber{
	protected String lastname;
	protected String firstname;
	protected String patronimic;
	protected int old;
	protected boolean gender=true;
	
	public String getLastname(){
		return lastname;
	}
	public String getFirstname(){
		return firstname;
	}
	public String getPatronimic(){
		return patronimic;
	}
	public int getOld(){
		return old;
	}
	public boolean getGender() {
		return gender;
	}
	public void setLastname(String lastname){
		this.lastname=lastname;
	}
	public void setFirstname(String firstname){
		this.firstname=firstname;
	}
	public void setPatronimic(String patronimic){
		this.patronimic=patronimic;
	}
	public boolean setOld(int old){
		if(old>=0){
			this.old=old;
			return true;
		}
		else return false;
	}
	public void info(){
		System.out.print("\nФамилия: "+lastname+"\nИм'я: "+firstname+"\nОтчество: "+patronimic+"\nВозраст: "+old);
	}
	
}