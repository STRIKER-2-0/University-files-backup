package tcpWork;

public class ShowBalanceOperation extends CardOperation {

    private String id = null;

    public ShowBalanceOperation(String id){
        this.id = id;
    }

    public ShowBalanceOperation(){

    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }
}
