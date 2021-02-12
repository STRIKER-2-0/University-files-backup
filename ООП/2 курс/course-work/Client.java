public class Client {
    private String name;
    private String surname;
    private int year;
    private long ID;
    
    Client(){
    	name = "somebody";
        surname = "any";
        year = 2000;
        ID = 00000000;
    }
    Client(String name, String surname, int year, int ID){
    	this.name = name;
        this.surname = surname;
        this.year = year;
        this.ID = ID;
    }
    public void setName(String name) {
		this.name = name;
	}
    public void setSurname(String surname) {
		this.surname = surname;
	}
    public void setYear(int year) {
		this.year = year;
	}
    public void setID(long iD) {
		ID = iD;
	}
    public String getName(){return name;}
    public String getSurname(){return surname;}
    public int getYear(){return year;}
    public long getID(){return ID;}
    
}
