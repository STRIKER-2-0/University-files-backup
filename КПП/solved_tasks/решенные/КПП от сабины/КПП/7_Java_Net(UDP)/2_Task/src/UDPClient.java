import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UDPClient {
    private Thread sendThread, reciveThread;
    private final static int port=7;
    private InetAddress addressServer;
    private DatagramSocket socket;
    private boolean isStop;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Введите аддресс сервера");
        try {
            new UDPClient(InetAddress.getByName(sc.nextLine()));
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public UDPClient(InetAddress addressServer) throws SocketException {
        socket=new DatagramSocket();
        this.addressServer = addressServer;
        this.isStop=false;
        sendThread =new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Запущен цикл отправки");
                Scanner sc=new Scanner(System.in);
                while (true){
                    if (isStop) break;
                    String str=sc.nextLine();
                    if (str.equals(".")) {
                        isStop=true;
                        break;
                    }

                    byte[] data=str.getBytes();
                    DatagramPacket packet=new DatagramPacket(data,data.length,addressServer,port);
                    try {
                        socket.send(packet);
                        Thread.yield();
                    } catch (IOException e) {
//                        e.printStackTrace();
                        System.out.println("Не удалось отправить");
                        break;
                    }
                }
                System.out.println("цикл отправки завершен");
            }
        });
        reciveThread =new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Запущен цикл приема");
                byte[] buffer=new byte[1024];
                while (true){
                    if (isStop) break;
                    DatagramPacket packet=new DatagramPacket(buffer,buffer.length);

                    try {
                        socket.receive(packet);
                        System.out.println(new String(packet.getData(),0,buffer.length,"UTF-8"));
                        Thread.yield();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("zxcz");
            }
        });
        try {
            System.out.println("Клиент запущен "+ InetAddress.getLocalHost()+" порт "+port);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        sendThread.start();
        reciveThread.start();
    }

    public void setStop(boolean stop) {
        isStop = stop;
    }

    public void stop() {
        isStop = true;
        sendThread.stop();
        reciveThread.stop();
        socket.close();
    }

    public boolean isStop() {
        return isStop;
    }
}
