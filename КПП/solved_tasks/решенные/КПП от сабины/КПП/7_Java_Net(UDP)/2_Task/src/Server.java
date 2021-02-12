import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server extends UDPServer {
    private final int DEFAULT_PORT;

    public Server() {
        super(7);
        DEFAULT_PORT = 7;
    }

    public static void main(String[] args) {
        Server server=new Server();
        new Thread(server).start();
    }
    @Override
    void respond(DatagramSocket socket, DatagramPacket packet) throws IOException {
        DatagramPacket backPacket=new DatagramPacket(packet.getData(),packet.getLength(),packet.getAddress(),packet.getPort());
        socket.send(backPacket);
    }
}
