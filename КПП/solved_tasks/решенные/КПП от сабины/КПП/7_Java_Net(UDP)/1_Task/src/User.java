import java.io.Serializable;
import java.net.InetAddress;

public class User implements Serializable {
    private InetAddress inetAddress;
    private int port;

    public User() {
        this.inetAddress = null;
        this.port = -1;
    }

    public User(InetAddress inetAddress, int port) {
        this.inetAddress = inetAddress;
        this.port = port;
    }

    public InetAddress getInetAddress() {
        return inetAddress;
    }

    public int getPort() {
        return port;
    }

    public void setInetAddress(InetAddress inetAddress) {
        this.inetAddress = inetAddress;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "User Inet Address: "+this.inetAddress+" port: "+port;
    }
}
