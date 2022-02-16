package interfaces;

import java.lang.*;
import entity.*;

public interface IMechanicRepo
{
	public void addMechanic(Mechanic m);
	public void deleteMechanic(String mechanicId);
	public Mechanic searchMechanic(String mechanicId);
	public void updateMechanicInfo(Mechanic m);
	public String[][] getMechanicUpdate();
}