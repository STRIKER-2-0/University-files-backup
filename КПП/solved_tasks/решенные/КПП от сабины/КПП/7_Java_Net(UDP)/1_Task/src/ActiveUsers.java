import javax.jws.soap.SOAPBinding;
import java.io.Serializable;
import java.util.ArrayList;

public class ActiveUsers implements Serializable {
    private ArrayList<User> users;

    public ActiveUsers() {
        this.users = new ArrayList<User>();
    }

    public void addUsers(User user) {
        this.users.add(user);
    }

    public boolean isEmpty(){
        return users.isEmpty();
    }

    public int size(){
        return users.size();
    }

    public boolean contains(User user){
        return users.contains(user);
    }

    public User get(int index){
        return users.get(index);
    }

    @Override
    public String toString() {
        StringBuilder str=new StringBuilder();
        for(User user:users)
            str.append(user+"\r\n");
        return str.toString();
    }
}
