package bulletinBoardService;

import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastSenderReceiver {
	private String name;
	private InetAddress addr;
	private int port = 3456;
	private MulticastSocket group; 
	
	
	public MulticastSenderReceiver(String name) {
		this.setName(name);
		try {
			addr = InetAddress.getByName("224.0.0.1"); 
			group = new MulticastSocket(port);
			new Receiver(group, addr).start();
			new Sender(group,addr,port,name).start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	} 
	
	public static void main(String[] args) {
		new MulticastSenderReceiver(args[0]);
	} 
}
