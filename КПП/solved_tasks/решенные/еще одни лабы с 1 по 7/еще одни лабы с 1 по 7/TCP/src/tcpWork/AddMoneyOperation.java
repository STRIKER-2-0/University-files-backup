package tcpWork;

public class AddMoneyOperation extends CardOperation {
    private String id = null;
    private double money = 0.0;

    public AddMoneyOperation(String id, double money){
        this.id = id;
        this.money = money;
    }

    public AddMoneyOperation(){
        this("null", 0.0);
    }

    public double getMoney(){
        return money;
    }

    public void setMoney(double money){
        this.money = money;
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }
}
