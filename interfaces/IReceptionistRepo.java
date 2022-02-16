package interfaces;

import java.lang.*;
import entity.*;

public interface IReceptionistRepo
{
	public void addReceptionist(Receptionist r);
	public void deleteReceptionist(String receptionistId);
	public Receptionist searchReceptionist(String receptionistId);
	public void updateReceptionistInfo(Receptionist r);
	public String[][] getReceptionistUpdate();
	public  String[][] getReservationStatus();
}