package entity;

import java.lang.*;

public class User
{
	private String userId;
	private String password;
	private int status;

	public User(){}

	public User(String userId,String password,int status)
	{
		this.userId=userId;
		this.password=password;
		this.status=status;
	}

	public void setUserId(String userId)
	{
		this.userId=userId;
	}
	public void setUserPassword(String password)
	{
		this.password=password;
	}

    public void setUserStatus(int status)
    {
    	this.status=status;
    }
	public String getUserId()
	{
		return userId;
	}
	public String getUserPassword()
	{
		return password;
	}
	public int getUserStatus()
	{
		return status;
	}

}