package udpWork;

import java.net.*;
import java.io.*;

public class UDPServer {
	private ActiveUsers userList = null;
	private DatagramSocket socket = null;
	private DatagramPacket packet = null;
	private InetAddress address = null;
	private int port = -1;
	
	public UDPServer(int serverPort)
	{
		try
		{
			socket = new DatagramSocket(serverPort);
			
		} catch(SocketException e)
		{
			System.out.println("Error: "+e);
		}
		
		userList = new ActiveUsers();
	}
	
	public void work(int bufferSize)
	{
		try
		{
			System.out.println("Server start......");
			while(true)
			{
				getUserData(bufferSize);
				log(address, port);
				sendUserData();
			}
			
			
		} catch(java.io.IOException e)
		{
			System.out.println("Error:"+e);
		
		} finally
		{
			System.out.println("Server end.....");
			socket.close();
		}
		
		
		
	}
	
	private void log(InetAddress address, int port)
	{
		System.out.println("Request from: "+address.getHostAddress()+
				"port: "+port);
	}
	
	private void getUserData(int bufferSize) throws java.io.IOException
	{
		byte[] buffer = new byte[bufferSize];
		packet = new DatagramPacket(buffer, buffer.length);
		socket.receive(packet);
		address = packet.getAddress();
		port = packet.getPort();
		User usr = new User(address, port);
		if(userList.isEmpty())
		{
			userList.add(usr);
		} else if (!userList.contains(usr))
		{
			userList.add(usr);
		}
		
		clear(buffer);
	}
	
	private void clear(byte[] b)
	{
		for(int i =0; i < b.length; i++)
		{
			b[i] = 0;
		}
	}
	
	private void sendUserData() throws java.io.IOException
	{
		byte[] buffer = "Hello".getBytes();
		packet = new DatagramPacket(buffer, buffer.length, address, port);
		socket.send(packet);
		for(int i = 0; i < userList.size(); i++)
		{
			ByteArrayOutputStream bout = new ByteArrayOutputStream();
			ObjectOutputStream out = new ObjectOutputStream(bout);
			out.writeObject(userList.get(i));
			buffer = bout.toByteArray();
			packet = new DatagramPacket(buffer, buffer.length, address, port);
			socket.send(packet);
			
		}
		
		buffer = "end".getBytes();
		packet = new DatagramPacket(buffer, 0, address, port);
		socket.send(packet);
	}

	
	public static void main(String[] args)
	{
		(new UDPServer(1501)).work(256);
	}
}
