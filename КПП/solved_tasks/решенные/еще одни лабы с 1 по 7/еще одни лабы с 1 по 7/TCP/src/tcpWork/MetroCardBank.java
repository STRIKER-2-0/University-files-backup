package tcpWork;

import java.util.ArrayList;

public class MetroCardBank {
    private ArrayList<MetroCard> store;

    public MetroCardBank(){
        store = new ArrayList<MetroCard>();
    }

    public int findMetroCard(String id){
        for (MetroCard crd : store){
            if(crd.getId().equals(id)) return store.indexOf(crd);
        }
        return -1;
    }

    public int numCards(){
        return store.size();
    }

    public void addCard(MetroCard newCard){
        store.add(newCard);
    }

    public Boolean removeCard(String id){
        for (MetroCard crd : store){
            if(crd.getId().equals(id)){
                store.remove(crd);
                return true;
            }
        }
        return false;
    }

    public Boolean addMoney(String id, double money){
        int index = findMetroCard(id);
        if(index == -1) return false;
        MetroCard target = store.get(index);
        target.setBalance(target.getBalance() + money);
        return true;
    }

    public boolean getMoney(String id, double money){
        int index = findMetroCard(id);
        if(index == -1) return false;
        MetroCard target = store.get(index);
        if(target.getBalance() - money >= 0) {
            target.setBalance(target.getBalance() - money);
            return true;
        } else return false;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder("List of MetroCards: ");
        for (MetroCard crd : store){
            buf.append("\n\n" + crd);
        }
        return buf.toString();
    }

    public ArrayList<MetroCard> getStore() {
        return store;
    }

    public void setStore(ArrayList<MetroCard> store) {
        this.store = store;
    }
}
