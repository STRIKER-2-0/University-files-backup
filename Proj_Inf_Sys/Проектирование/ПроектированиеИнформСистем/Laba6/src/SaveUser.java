import java.util.ArrayList;
import java.util.List;

public class SaveUser {
    private List<Memento> list = new ArrayList<Memento>();
    public void add(Memento memento){
        list.add(memento);
    }
    public Memento get(int ind){
        return list.get(ind);
    }
}
