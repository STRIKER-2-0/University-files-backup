import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Handler extends Thread{
    private ObjectOutputStream oos = null;
    private ObjectInputStream ois = null;
    private boolean isWork = true;
    private Socket socket = null;

    public Handler(Socket socket){
        this.socket = socket;
        try {
            oos=new ObjectOutputStream(socket.getOutputStream());
            ois=new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        synchronized (this){
            System.out.println("Handler Starts...");
            while (isWork){
                String str;
                try {
                    str = (String) ois.readObject();
                    oos.writeObject(str.toUpperCase());
                    oos.flush();
                    isWork = false;
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
            try {
                System.out.println("Handler Starts...");
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
