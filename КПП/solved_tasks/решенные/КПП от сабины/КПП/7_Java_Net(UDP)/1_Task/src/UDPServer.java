import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.*;


public class UDPServer {
    private ActiveUsers users;
    private DatagramSocket socket;
    private DatagramPacket packet;
    private InetAddress address;
    private int port;

    public static void main(String[] args) {
        new UDPServer(8081).work(256);
    }

    public UDPServer() {
        users=new ActiveUsers();
        socket=null;
        packet=null;
        address=null;
        port=-1;
    }

    public UDPServer(int port) {
        this();
        try {
            socket=new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        this.port = port;
    }

    public void work(int bufferSize){
        try {
            System.out.println("Server start "+InetAddress.getLocalHost()+" port: "+port);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        try {
            while (true){
                getUsersData(bufferSize);
                log(address,port);
                sendUserData();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            System.out.println("Server crash");
            socket.close();
        }

    }

    private void log(InetAddress address,int port){
        System.out.println("Request from: "+address.getHostAddress()+" port: "+port);
    }

    private void getUsersData(int bufferedSize) throws IOException {
        byte[] buffer=new byte[bufferedSize];
        packet=new DatagramPacket(buffer,bufferedSize);
        socket.receive(packet);

        User user=new User(address=packet.getAddress(),port=packet.getPort());
//        System.out.println("z"+ address);
//        System.out.println("z"+port);
        if(!users.contains(user))
            users.addUsers(user);
    }

    private void sendUserData() throws IOException{
        byte[] buffer;
        for (int i=0;i<users.size();i++){
            ByteArrayOutputStream bais=new ByteArrayOutputStream();
            ObjectOutputStream oos=new ObjectOutputStream(bais);
            oos.writeObject(users.get(i));
            buffer=bais.toByteArray();
            packet=new DatagramPacket(buffer,buffer.length,address,port);
            socket.send(packet);
        }
        buffer="end".getBytes();
        socket.send(new DatagramPacket(buffer,0,address,port));
    }
}
