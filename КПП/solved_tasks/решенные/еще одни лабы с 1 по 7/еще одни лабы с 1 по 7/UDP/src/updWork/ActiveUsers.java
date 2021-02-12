package udpWork;

import java.util.ArrayList;

public class ActiveUsers implements java.io.Serializable
{
	ArrayList<User> users = null;
	
	public ActiveUsers()
	{
		users = new ArrayList<User>();
	}
	
	public void add(User user)
	{
		users.add(user);
	}
	
	public boolean isEmpty()
	{
		return users.isEmpty();
	}
	
	public int size()
	{
		return users.size();
	}

	public boolean contains(User user)
	{
		return users.contains(user);
	}
	
	public User get(int index)
	{
		return users.get(index);
	}
	
	@Override
	public String toString()
	{
		java.lang.StringBuffer buf = new java.lang.StringBuffer();
		for (User u: users)
		{
			buf.append(u+"\n");
		}
		return buf.toString();
	}
	
	
}
