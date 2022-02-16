package interfaces;

import java.lang.*;
import entity.*;

public interface IClerkRepo
{
	public void addClerk(Clerk c);
	public void deleteClerk(String clerkID);
	public void updateClerkInfo(Clerk c);
	public Clerk searchClerk(String clerkId);
	public String[][] getEmployeeUpdate();
	public String[][] getClerkUpdate();
}