import java.io.IOException;
import java.net.*;

public abstract class UDPServer implements Runnable{
    private final int bufferSize;
    private final int port;
    private boolean isShutDown;

    public UDPServer(){
        this(512,8080);
    }

    public UDPServer(int port) {
        this(512,port);
    }

    public UDPServer(int bufferSize, int port) {
        this.bufferSize = bufferSize;
        this.port = port;
        this.isShutDown=false;
    }

    @Override
    public void run() {
        try {
            System.out.println("Сервер запущен "+InetAddress.getLocalHost()+" порт "+port);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        isShutDown=false;
        byte[] buffer=new byte[bufferSize];
        try(DatagramSocket socket=new DatagramSocket(port)) {
            socket.setSoTimeout(10000);
            while (true){
                if (isShutDown) return;
                DatagramPacket packet=new DatagramPacket(buffer,bufferSize);

                try {
                    socket.receive(packet);
                    this.respond(socket,packet);
                } catch (SocketTimeoutException e) {
                    if (isShutDown) return;
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (SocketException e) {
//            e.printStackTrace();
            System.out.println("Порт занят");
        }
    }

    public boolean isShutDown() {
        return isShutDown;
    }

    public void ShutDown() {
        isShutDown = true;
    }

    abstract void respond(DatagramSocket socket, DatagramPacket packet) throws IOException;
}
