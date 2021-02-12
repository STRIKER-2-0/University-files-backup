package tcpWork;

public class RemoveCardOperation extends CardOperation {
    private String id = null;

    public RemoveCardOperation(String id){
        this.id = id;
    }

    public RemoveCardOperation(){

    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }
}
