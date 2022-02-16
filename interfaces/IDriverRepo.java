package interfaces;

import java.lang.*;
import entity.*;

public interface IDriverRepo
{
	public void addDriver(Driver d);
	public void deleteDriver(String driverId);
	public void updateDriverInfo(Driver d);
	public Driver searchDriver(String driverId);
	public String[][] getDriverUpdate();
}