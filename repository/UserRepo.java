package repository;

import java.lang.*;
import entity.*;
import interfaces.*;

public class UserRepo implements IUserRepo
{
	DatabaseConnection dbc;

    public UserRepo()
    {
    	dbc = new DatabaseConnection();
    }

	public User getUserInfo(String userId,String password)
	{
       User user = null;
		String query = "SELECT userId, password, status FROM logindata WHERE userId='"+userId+"' AND password='"+password+"';";
		try
		{
			System.out.println(query);
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				user = new User();
				user.setUserId(dbc.result.getString("userId"));
				user.setUserPassword(dbc.result.getString("password"));
				user.setUserStatus(dbc.result.getInt("status"));
			}
		}
        catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
        }
		dbc.closeConnection();
		return user;
	}
	
	public void insertUser(User u)
	{
       String query = "INSERT INTO logindata VALUES ('"+u.getUserId()+"','"+u.getUserPassword()+"',"+u.getUserStatus()+");";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
		}
	}
	public void deleteUser(String userId)
	{
       String query = "DELETE from logindata  WHERE userId='"+userId+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e)
		{
			System.out.println("Exception : " +e.getMessage());
		}
	}
	public void updateUserInfo(User u)
	{
		 String query = "UPDATE `logindata` SET `password`="+u.getUserPassword()+" WHERE `userId`='"+u.getUserId()+"';"; 
		try 
		{
			System.out.println(query);
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
		}
	}
}
