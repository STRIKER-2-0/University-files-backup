import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.*;

public class UDPClient {
    private ActiveUsers users;
    private DatagramSocket socket;
    private DatagramPacket packet;
    private InetAddress address;
    private int port;

    public static void main(String[] args) {
        (new UDPClient("127.0.0.1",8081)).work(256);
    }

    public UDPClient() {
        users=new ActiveUsers();
        socket=null;
        packet=null;
        address=null;
        port=-1;
    }

    public UDPClient(String address,int port) {
        this();
        try {
            this.address=InetAddress.getByName(address);
            socket=new DatagramSocket();
            socket.setSoTimeout(1000);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        this.port = port;
    }

    public void work(int bufferedSize){
        byte[] buffer=new byte[bufferedSize];
        try {
            packet=new DatagramPacket(buffer,bufferedSize,address,port);
            socket.send(packet);
            System.out.println("Запрос отправлен");

            while (true){
                packet=new DatagramPacket(buffer,bufferedSize);
                socket.receive(packet);
                if(packet.getLength()==0) break;
                ObjectInputStream ois=new ObjectInputStream(new ByteArrayInputStream(packet.getData(),0,packet.getLength()));
                User user=(User) ois.readObject();
                if(!users.contains(user))
                    users.addUsers(user);
            }
        } catch (IOException e) {
//            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Кол-во пользователей: "+users.size());
        System.out.println(users);
    }

}
