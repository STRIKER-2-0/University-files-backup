package task3;

public class Author extends Human{
    public Author(String name, String surname){
        setSurname(surname);
        setName(name);
    }

    public Author(){
        this("Roma", "Bohdan");
    }

    public String toString(){
        return super.toString();
    }
}
