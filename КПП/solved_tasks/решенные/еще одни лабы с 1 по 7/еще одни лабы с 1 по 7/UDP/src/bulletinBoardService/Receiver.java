package bulletinBoardService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Receiver extends Thread{
	private MulticastSocket group;
	private InetAddress addr;
	
	public Receiver(MulticastSocket group, InetAddress addr) {
		this.group = group;
		this.addr = addr;
	}
	
	public void run(){
		try {
			byte[] in = new byte[256];
			DatagramPacket pkt = new DatagramPacket(in, in.length);
			group.joinGroup(addr);
			while (true) {
				group.receive(pkt);
				System.out.println(new String(pkt.getData(), 0, pkt.getLength()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
