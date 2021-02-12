package tcpWork;

public class ShowCardInfoOperation extends CardOperation {
    private String id = null;

    public ShowCardInfoOperation(String id){
        this.id = id;
    }

    public ShowCardInfoOperation(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
