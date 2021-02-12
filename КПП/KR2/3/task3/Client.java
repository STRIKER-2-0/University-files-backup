

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    private int port =-1;
    private String server = null;
    private Socket socket = null;
    private ObjectInputStream ois = null;
    private ObjectOutputStream oos = null;

    public Client(String server, int port){
        this.port = port;
        try{
            socket = new Socket();
            socket.connect(new InetSocketAddress(server,port),1000);
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void sendTask(String str) throws IOException {
        try {
            oos.writeObject(str);
            oos.flush();
            System.out.println(ois.readObject());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        Client cl = new Client("localhost",3456);
        cl.sendTask("testing...");
    }
}
