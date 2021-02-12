import java.io.Externalizable;

public abstract class Human implements Externalizable {
    private String firstName;
    private String surname;

    public Human(){
        firstName=new String();
        surname=new String();
    }

    public Human(String firstName,String surname){
        this.firstName=firstName;
        this.surname=surname;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return firstName+" "+surname;
    }
}
