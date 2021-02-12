package udpWork;

import java.net.InetAddress;

public class User implements java.io.Serializable 
{
	static final int serialVersionUID = 1;
	
	private InetAddress ip;
	private int port;
	
	public User(InetAddress ip, int port)
	{
		this.ip = ip;
		this.port = port;
	}
	
	
	public User()
	{
		port = 0;
		
	}
	
	public InetAddress getInetAddress()
	{
		return ip;
	}
	
	public void setInetAddress(InetAddress ip)
	{
		this.ip = ip;
	}
	
	public int getPort()
	{
		return port;
	}
	
	public void setPort(int port)
	{
		this.port = port;
	}
	
	@Override 
	public String toString()
	{
		return "ip="+ip+";port="+port+"\n";
	}
	
	

}
