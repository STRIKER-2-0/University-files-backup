import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread{
    private ServerSocket serverSocket = null;
    private int port = -1;

    public Server(int port){
            this.port = port;
    }

    @Override
    public void run() {
        try {
            this.serverSocket = new ServerSocket(port);
            System.out.println("Server Starts...");
            while (true){
                System.out.println("Waiting...");
                Socket socket = serverSocket.accept();
                System.out.println("New client connected!");
                Handler h = new Handler(socket);
                h.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Server(3456).start();
    }
}
