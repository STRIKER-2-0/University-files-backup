package tcpWork;

import java.io.Serializable;

public class MetroCard implements Serializable {
    private String id;
    private User usr;
    private String colledge;
    private double balance;

    
    public MetroCard(){
        id = "00001";
        usr = new User();
        colledge = "Undefined University";
        balance = 0.00;
    }

    public MetroCard(String id, User usr, String colledge, double balance){
        this.id = id;
        this.usr = usr;
        this.colledge = colledge;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "№: " + id + "\nUser: " + usr + "\nColledge: " + colledge + "\nBalance: " + balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUsr() {
        return usr;
    }

    public void setUsr(User usr) {
        this.usr = usr;
    }

    public String getColledge() {
        return colledge;
    }

    public void setColledge(String colledge) {
        this.colledge = colledge;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
