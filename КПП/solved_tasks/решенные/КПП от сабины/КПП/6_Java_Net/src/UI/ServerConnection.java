package UI;

import Interfaces.Executable;
import Interfaces.Result;
import server.ResultImpl;
import server.Server;

import java.io.*;
import java.net.Socket;

public class ServerConnection implements Runnable {
    private Server server;
    private Socket socket;
    private boolean stop;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;

    public ServerConnection(Server server, Socket socket) throws IOException {
        this.socket=socket;
        this.server=server;
        this.createCanal();
        this.stop=false;
    }
    private void createCanal() throws IOException{
        this.oos=new ObjectOutputStream(socket.getOutputStream());
        this.ois=new ObjectInputStream(socket.getInputStream());
    }

    private void reciveMsg(){
        try {
            String str=(String) ois.readObject();
            if(str.equals("q")) throw new IOException();

            str=str.replaceFirst("client","server");
            //получаем и записываем класс-файл НО ЗАЧЕМ!?
            byte[] b=(byte[])ois.readObject();
            FileOutputStream fos=new FileOutputStream(str);
            fos.write(b);
            ////////////////////////
//            server.doJob((Executable) ois.readObject());

            Executable executable=(Executable) ois.readObject();
            server.getFrame().showString("\tПолучено задание от "+this.socket.getLocalAddress()+"\r\n");
            //otvet

            server.getFrame().showString("\tВычисление и отправка ответа\r\n");
            sendOutput(server.doJob(executable));
            server.getFrame().showString("\tОтвет отправлен\r\n");

        } catch (IOException e) {
//            e.printStackTrace();
            stop=true;
            server.offConnection(this);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void sendOutput(Result result) throws IOException {
        String classFile="C:\\Users\\Максим\\Desktop\\CPP\\6_Java_Net\\out\\production\\6_Java_Net\\server\\ResultImpl.class";
        oos.writeObject(classFile);
        //отправка класс-файла
        FileInputStream fis=new FileInputStream(classFile);
        byte[] b=new byte[fis.available()];
        fis.read(b);
        oos.writeObject(b);
        //////////////////////////
        oos.writeObject(result);
        oos.flush();
    }

    @Override
    public void run() {
        while(!stop){
            reciveMsg();
        }
    }

    public Socket getSocket() {
        return socket;
    }

    public void offServerConnection() throws IOException{
        oos.writeObject("q");
        oos.flush();
    }
}
