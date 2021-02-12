package bulletinBoardService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Sender extends Thread{
	private InetAddress addr;
	private int port;
	private MulticastSocket group;
	private String name;
	
	public Sender(MulticastSocket group, InetAddress address, int port,String name) {
		this.addr = address;
		this.port = port;
		this.group = group;
		this.group.connect(addr, port);
		this.name = name;
	} 
	
	public void run(){
		try{
			BufferedReader fromUser = new BufferedReader(new 
					InputStreamReader(System.in));
			while (true) {
				String msg = name + ":" + fromUser.readLine();
				byte[] out = msg.getBytes();
				DatagramPacket pkt = new DatagramPacket(out, out.length, addr, port);
				group.send(pkt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
