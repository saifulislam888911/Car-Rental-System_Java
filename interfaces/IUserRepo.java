package interfaces;

import java.lang.*;
import entity.*;

public interface IUserRepo
{
	User getUserInfo(String userId,String password);
	void insertUser(User u);
	void deleteUser(String userId);
	void updateUserInfo(User u);
}