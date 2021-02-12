import java.io.*;

public class Author extends Human implements Externalizable {

    public Author(){
        super();
    }

    public Author(String firstName, String surname) {
        super(firstName, surname);
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(getFirstName());
        out.writeObject(getSurname());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        setFirstName((String) in.readObject());
        setSurname((String)in.readObject());
    }
}
