package tcpWork;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MetroServer extends Thread {
    MetroCardBank bnk = null;
    private ServerSocket srvSocket = null;
    private int srvPort = -1;

    public MetroServer(int port){
        this.bnk = new MetroCardBank();
        this.srvPort = port;
    }


    @Override
    public void run() {
        try{
            this.srvSocket = new ServerSocket(srvPort);
            System.out.println("Metro Server started!");
            while(true){
                System.out.println("New Client Awaiting...");
                Socket socket = srvSocket.accept();
                System.out.println("New Client: " + socket);
                ClientHandler ch = new ClientHandler(this.getBnk(), socket);
                ch.start();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e);
        } finally{
            try{
                srvSocket.close();
                System.out.println("Metro Server Stopped");
            } catch (IOException e) {
                System.out.println("Error: " + e);
            }
        }
    }

    private void stopServer() throws IOException {
        srvSocket.close();
    }

    public static void main(String[] args){
        MetroServer srv = new MetroServer(7891);
        srv.start();
    }


    public MetroCardBank getBnk() {
        return bnk;
    }
}
