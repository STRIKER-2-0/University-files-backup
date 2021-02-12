package tcpWork;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {
    private int port = -1;
    private String server = null;
    private Socket socket = null;
    private ObjectInputStream in = null;
    private ObjectOutputStream out = null;

    public Client(String server, int port){
        this.port = port;
        this.server = server;
        try{
            socket = new Socket();
            socket.connect(new InetSocketAddress(server,port), 1000);
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    public void finish(){
        try{
            out.writeObject(new StopOperation());
            out.flush();
            System.out.println(in.readObject());
        } catch (IOException e) {
            System.out.println("Error: " + e);
        } catch (ClassNotFoundException e) {
            System.out.println("Error: " + e);
        }
    }

    public void applyOperation(CardOperation op){
        try{
            out.writeObject(op);
            out.flush();
            System.out.println(in.readObject());
        } catch (IOException e) {
            System.out.println("Error: " + e);
        } catch (ClassNotFoundException e) {
            System.out.println("Error: " + e);
        }
    }


    public static void main(String[] args){
        
        Client cl = new Client("localhost", 7891);
        AddMetroCardOperation op = new AddMetroCardOperation();
        op.getCrd().setUsr(new User("Nikita","Litvinov","M", "30.06.1999"));
        op.getCrd().setId("001");
        op.getCrd().setColledge("Kharkiv Karazin University");
        op.getCrd().setBalance(69);
        cl.applyOperation(op);
        cl.finish();
        //
        cl = new Client("localhost", 7891);
        cl.applyOperation(new ShowBalanceOperation("001"));
        cl.applyOperation(new PayMoneyOperation("001", 3.5));
        cl.applyOperation(new ShowBalanceOperation("001"));
        cl.finish();

        cl = new Client("localhost", 7891);
        cl.applyOperation(new ShowCardInfoOperation("001"));
        cl.finish();
    }

}
