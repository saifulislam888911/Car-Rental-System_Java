package repository;

import java.lang.*;
import interfaces.*;
import entity.*;
import java.util.ArrayList;

public class ReceptionistRepo implements IReceptionistRepo,ICarRepo
{
	DatabaseConnection dbc;

	public ReceptionistRepo()
	{
		dbc = new DatabaseConnection();
	}

	public void addReceptionist(Receptionist r){}
	public void deleteReceptionist(String receptionistId){}
	public Receptionist searchReceptionist(String receptionistId)
	{
		Receptionist r = null;
		String query = "SELECT `receptionistName`, `receptionistSalary`,`joinDate` FROM `reciptionist` WHERE `receptionistId`='"+receptionistId+"';";
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
		while(dbc.result.next())
			{
				
				//String receptionistId = dbc.result.getString("receptionistId");
				String receptionistName = dbc.result.getString("receptionistName");
				double receptionistSalary = dbc.result.getDouble("receptionistSalary");
				String joinDate = dbc.result.getString("joinDate");
				
				r = new Receptionist();
				r.setReceptionistId(receptionistId);
				r.setReceptionistName(receptionistName);
				r.setReceptionistSalary(receptionistSalary);
				r.setReceptionistJoinDate(joinDate);
			}
			
		}
		catch(Exception ex)
		   {
			  System.out.println("Exception : "+ ex.getMessage());
		   }
	   dbc.closeConnection();
	   return r;
	}
	public void updateReceptionistInfo(Receptionist r){}

	public String[][] getReceptionistUpdate()
	{
        ArrayList<Receptionist> array = new ArrayList<Receptionist>();
		String query = "SELECT * FROM reciptionist;";  
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				String receptionistId = dbc.result.getString("receptionistId");
				String receptionistName = dbc.result.getString("receptionistName");
				double receptionistSalary = dbc.result.getDouble("receptionistSalary");
				String joinDate = dbc.result.getString("joinDate");
				
				Receptionist r = new Receptionist(receptionistId,receptionistName,receptionistSalary,joinDate);
				array.add(r);
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception : " +e.getMessage());
		}
		dbc.closeConnection();
		
		
		Object obj[] = array.toArray();
		String data[][] = new String [array.size()][4];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Receptionist)obj[i]).getReceptionistId();
			data[i][1] = ((Receptionist)obj[i]).getReceptionistName();
			data[i][2] = (((Receptionist)obj[i]).getReceptionistSalary())+"";
			data[i][3] = (((Receptionist)obj[i]).getReceptionistJoinDate())+"";
		}
		return data;
	}

	public String[][] getReservationStatus()
	{
		ArrayList<Car> array = new ArrayList<Car>();
		String query = "SELECT * FROM `car`;";  
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				String carId = dbc.result.getString("carId");
				String brand = dbc.result.getString("brand");
				String carLicence =dbc.result.getString("carLicence");
				String reservationStatus = dbc.result.getString("reservationStatus");
				String carType =dbc.result.getString("carType");
				int numberOfseat = dbc.result.getInt("numberOfseat");				
				Car c = new Car(carId,brand,carLicence,reservationStatus,carType,numberOfseat);
				array.add(c);
			}
		}
		catch(Exception e){System.out.println("Exception : "+e.getMessage());}
		dbc.closeConnection();
		
		
		Object obj[] = array.toArray();
		String data[][] = new String [array.size()][4];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Car)obj[i]).getCarId();
			data[i][1] = ((Car)obj[i]).getBrand();
			data[i][2] = ((Car)obj[i]).getReservationStatus();
			data[i][3] = (((Car)obj[i]).getNumberOfSeat())+"";
		}
		return data;
	}

	public void addCar(Car cc){}
	public void deleteCar(String carLience){}
	public void updateCarInfo(Car cc)
	{
		String query = "UPDATE `car` SET `ReservationStatus`= '"+cc.getReservationStatus()+"' WHERE `CarID`= '"+cc.getCarId()+"';";
		try 
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex)
		{
			System.out.println("Exception : " + ex.getMessage());
		}
	}
	public Car searchCar(String carId)
    {
    	Car cc = null;
		String query = "SELECT `reservationStatus` FROM `car` WHERE `carId`='"+carId+"';";
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
		while(dbc.result.next())
			{
				String reservationStatus = dbc.result.getString("reservationStatus");
				
				cc = new Car();
				cc.setReservationStatus(reservationStatus);
			}
			
		}
		catch(Exception ex)
		   {
			  System.out.println("Exception :" + ex.getMessage());
		   }
	   dbc.closeConnection();
	   return cc;
    }
	public String[][] getCarDetails()
	{
		ArrayList<Car> array = new ArrayList<Car>();
		String query = "SELECT * FROM car;";  
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				String carId = dbc.result.getString("carId");
				String brand = dbc.result.getString("brand");
				String carLicence =dbc.result.getString("carLicence");
				String reservationStatus = dbc.result.getString("reservationStatus");
				String carType = dbc.result.getString("carType");
				int numberOfseat = dbc.result.getInt("numberOfseat");
				
				Car c = new Car(carId,brand,carLicence,reservationStatus,carType,numberOfseat);
				array.add(c);
			}
		}
		catch(Exception ex){System.out.println("Exception : " + ex.getMessage());}
		dbc.closeConnection();
		
		
		Object obj[] = array.toArray();
		String data[][] = new String [array.size()][4];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Car)obj[i]).getCarId();
			data[i][1] = ((Car)obj[i]).getBrand();
			//data[i][2] = ((Car)obj[i]).getCarLicence();
			data[i][2] = ((Car)obj[i]).getReservationStatus();
			//data[i][4] = (((Car)obj[i]).getCarType());
			data[i][3] = (((Car)obj[i]).getNumberOfSeat())+"";
		}
		return data;
	}
}	