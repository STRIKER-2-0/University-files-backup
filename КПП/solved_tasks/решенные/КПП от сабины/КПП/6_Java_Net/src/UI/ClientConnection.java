package UI;

import Interfaces.Executable;
import Interfaces.Result;
import client.Client;

import javax.swing.*;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class ClientConnection implements Runnable {
    private Client client;
    private InetAddress inetAddress;
    private Socket socket;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    private boolean stop;
    private ClientFrame clientFrame;

    public ClientConnection() throws IOException {
        socket=new Socket(this.inetAddress=InetAddress.getLocalHost(),8080);
        createCanal();
        stop=false;
        client=new Client();
    }

    public ClientConnection(InetAddress inetAddress,int port) throws IOException {
        socket=new Socket(this.inetAddress=inetAddress,port);
        createCanal();
        stop=false;
        client=new Client();
    }

    public ClientConnection(InetAddress inetAddress,int port,ClientFrame clientFrame) throws IOException {
        this(inetAddress,port);
        this.clientFrame=clientFrame;
    }

    public InetAddress getInetAddress() {
        return inetAddress;
    }

    @Override
    public void run() {
        while(!stop){
            try {
                reciveMsg();
            } catch (IOException e) {
//                e.printStackTrace();
                stop=true;
//                clientFrame.showString("Нет подключения к серверу");
                clientFrame.setClientConnection(null);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void reciveMsg() throws IOException, ClassNotFoundException {
        String str=(String) ois.readObject();
        if (str.equals("q")){
            throw new IOException();
        }

        String nameClasssFile=str;
        nameClasssFile=nameClasssFile.replaceFirst("server","client");
        //запись класс-файла
        FileOutputStream fos=new FileOutputStream(nameClasssFile);
        byte[] b=(byte[]) ois.readObject();
        fos.write(b);
        ////////////////////////////

        Result result=(Result) ois.readObject();
//        System.out.println(result.output());
        clientFrame.showString("Result "+result.output().toString()+"\r\n");
        clientFrame.showString("Time "+result.scoreTime()+"ns\r\n");
    }

    public void offConnect() throws IOException {
        stop=true;
        oos.writeObject("q");
        oos.flush();
        oos.close();
        ois.close();
    }

    public void sendJob(Executable executable) throws IOException {
        String nameClassFile="C:\\Users\\Максим\\Desktop\\CPP\\6_Java_Net\\out\\production\\6_Java_Net\\client\\JobOne.class";
        oos.writeObject(nameClassFile);
        //отправка класс-файла
        FileInputStream fis=new FileInputStream(nameClassFile);
        byte[] b=new byte[fis.available()];
        fis.read(b);
        oos.writeObject(b);
        //////////////////////////

        oos.writeObject(executable);
    }
    private void createCanal() throws IOException{
        this.oos=new ObjectOutputStream(socket.getOutputStream());
        this.ois=new ObjectInputStream(socket.getInputStream());
    }
}
