package repository;

import java.lang.*;
import java.util.ArrayList;
import entity.*;
import interfaces.*;

public class ClerkRepo implements IReceptionistRepo,IWorkerRepo,IMechanicRepo,IDriverRepo,IClerkRepo
{
	DatabaseConnection dbc;

	public ClerkRepo()
	{
		dbc = new DatabaseConnection();
	}

	public String[][] getEmployeeUpdate()
	{
		ArrayList<Employee> array = new ArrayList<Employee>();
		String query = "SELECT * FROM employee;";  
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				String employeeId = dbc.result.getString("employeeId");
				String employeeName = dbc.result.getString("employeeName");
				double employeeSalary = dbc.result.getDouble("employeeSalary");
				String jobType = dbc.result.getString("jobType");
				String joinDate = dbc.result.getString("joinDate");
				
				Employee e = new Employee(employeeId,employeeName,employeeSalary,jobType,joinDate);
				array.add(e);
			}
		}
		catch(Exception e){System.out.println(e.getMessage());}
		dbc.closeConnection();
		
		
		Object obj[] = array.toArray();
		String data[][] = new String [array.size()][5];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Employee)obj[i]).getEmployeeId();
			data[i][1] = ((Employee)obj[i]).getEmployeeName();
			data[i][2] = ((Employee)obj[i]).getEmployeeSalary()+"";
			data[i][3] = (((Employee)obj[i]).getJobType());
			data[i][4] = (((Employee)obj[i]).getEmployeeJoinDate())+"";
		}
		return data;
	}

	public void addClerk(Clerk c)
	{
		String query = "INSERT INTO clerk VALUES ('"+c.getClerkId()+"','"+c.getClerkName()+"','"+c.getClerkSalary()+"','"+c.getClerkJoinDate()+"');";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex)
		     {
		     	System.out.println(ex.getMessage());
		     }
	}
	public void deleteClerk(String clerkId)
	{
		String query = "DELETE from clerk WHERE clerkId='"+clerkId+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	public void updateClerkInfo(Clerk c)
	{
		String query = "UPDATE clerk SET clerkName = '"+c.getClerkName()+"', clerkSalary = '"+c.getClerkSalary()+"', joinDate = '"+c.getClerkJoinDate()+"' WHERE clerkId='"+c.getClerkId()+"';";
		try 
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}

	public Clerk searchClerk(String clerkId)
	{
		Clerk c = null;
		String query = "SELECT `clerkId`, `clerkName`, `clerkSalary`,`joinDate` FROM `clerk` WHERE `clerkId`='"+clerkId+"';";
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
		while(dbc.result.next())
			{
				
				//String clerkId = dbc.result.getString("clerkId");
				String clerkName = dbc.result.getString("clerkName");
				double clerkSalary = dbc.result.getDouble("clerkSalary");
				String joinDate = dbc.result.getString("joinDate");
				
				c = new Clerk();
				c.setClerkId(clerkId);
				c.setClerkName(clerkName);
				c.setClerkSalary(clerkSalary);
				c.setClerkJoinDate(joinDate);
			}
			
		}
		catch(Exception ex)
		   {
			  System.out.println("Exception : "+ ex.getMessage());
		   }
	   dbc.closeConnection();
	   return c;
	}

	public String[][] getClerkUpdate()
	{
		ArrayList<Clerk> array = new ArrayList<Clerk>();
		String query = "SELECT * FROM clerk;";  
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				String clerkId = dbc.result.getString("clerkId");
				String clerkName = dbc.result.getString("clerkName");
				double clerkSalary = dbc.result.getDouble("clerkSalary");
				String joinDate = dbc.result.getString("joinDate");
				
				Clerk c = new Clerk(clerkId,clerkName,clerkSalary,joinDate);
				array.add(c);
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
			data[i][0] = ((Clerk)obj[i]).getClerkId();
			data[i][1] = ((Clerk)obj[i]).getClerkName();
			data[i][2] = ((Clerk)obj[i]).getClerkSalary()+"";
			data[i][3] = (((Clerk)obj[i]).getClerkJoinDate())+"";
		}
		return data;
	}

	public void addReceptionist(Receptionist r)
	{
		String query = "INSERT INTO reciptionist VALUES ('"+r.getReceptionistId()+"','"+r.getReceptionistName()+"','"+r.getReceptionistSalary()+"','"+r.getReceptionistJoinDate()+"');";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex)
		     {
		     	System.out.println("Exception : "+ex.getMessage());
		     }
	}
	public void deleteReceptionist(String receptionistId)
	{
		String query = "DELETE from reciptionist WHERE receptionistId='"+receptionistId+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	public void updateReceptionistInfo(Receptionist r)
	{
		String query = "UPDATE reciptionist SET receptionistName = '"+r.getReceptionistName()+"', receptionistSalary = '"+r.getReceptionistSalary()+"', joinDate = '"+r.getReceptionistJoinDate()+"' WHERE receptionistId='"+r.getReceptionistId()+"';";
		try 
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex)
		{
			System.out.println("Exception : "+ex.getMessage());
		}
	}

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

	public void addWorker(Worker w)
	{
       String query = "INSERT INTO worker VALUES ('"+w.getWorkerId()+"','"+w.getWorkerName()+"','"+w.getWorkerSalary()+"','"+w.getWorkerJoinDate()+"');";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex)
		     {
		     	System.out.println(ex.getMessage());
		     }
	}
	public void deleteWorker(String workerId)
	{
        String query = "DELETE from worker WHERE workerId='"+workerId+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex)
		{
			System.out.println("Exception : "+ex.getMessage());
		}
	}
	public void updateWorkerInfo(Worker w)
	{
       String query = "UPDATE worker SET workerName = '"+w.getWorkerName()+"', workerSalary = '"+w.getWorkerSalary()+"', joinDate = '"+w.getWorkerJoinDate()+"' WHERE workerId='"+w.getWorkerId()+"';";
		try 
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}

    public Worker searchWorker(String workerId)
	{
		Worker w = null;
		String query = "SELECT `workerId`, `workerName`, `workerSalary`,`joinDate` FROM `worker` WHERE `workerId`='"+workerId+"';";
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
		while(dbc.result.next())
			{
				
				//String workerId = dbc.result.getString("workerId");
				String workerName = dbc.result.getString("workerName");
				double workerSalary = dbc.result.getDouble("workerSalary");
				String joinDate = dbc.result.getString("joinDate");
				
				w = new Worker();
				w.setWorkerId(workerId);
				w.setWorkerName(workerName);
				w.setWorkerSalary(workerSalary);
				w.setWorkerJoinDate(joinDate);
			}
			
		}
		catch(Exception ex)
		   {
			  System.out.println("Exception : "+ ex.getMessage());
		   }
	   dbc.closeConnection();
	   return w;
	}

	public String[][] getWorkerUpdate()
	{
		ArrayList<Worker> array = new ArrayList<Worker>();
		String query = "SELECT * FROM worker;";  
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				String workerId = dbc.result.getString("workerId");
				String workerName = dbc.result.getString("workerName");
				double workerSalary = dbc.result.getDouble("workerSalary");
				String joinDate = dbc.result.getString("joinDate");
				
				Worker w = new Worker(workerId,workerName,workerSalary,joinDate);
				array.add(w);
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
			data[i][0] = ((Worker)obj[i]).getWorkerId();
			data[i][1] = ((Worker)obj[i]).getWorkerName();
			data[i][2] = (((Worker)obj[i]).getWorkerSalary())+"";
			data[i][3] = (((Worker)obj[i]).getWorkerJoinDate())+"";
		}
		return data;
	}

	public void addMechanic(Mechanic m)
	{
       String query = "INSERT INTO mechanic VALUES ('"+m.getMechanicId()+"','"+m.getMechanicName()+"','"+m.getMechanicSalary()+"','"+m.getMechanicJoinDate()+"');";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex)
		     {
		     	System.out.println("Exception : "+ex.getMessage());
		     }
	}
	public void deleteMechanic(String mechanicId)
	{
       String query = "DELETE from mechanic WHERE mechanicId='"+mechanicId+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex)
		{
			System.out.println("Exception : "+ex.getMessage());
		}
	}
	public void updateMechanicInfo(Mechanic m)
	{
       String query = "UPDATE mechanic SET mechanicName = '"+m.getMechanicName()+"', mechanicSalary = '"+m.getMechanicSalary()+"', joinDate = '"+m.getMechanicJoinDate()+"' WHERE mechanicId='"+m.getMechanicId()+"';";
		try 
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex)
		{
			System.out.println("Exception : "+ex.getMessage());
		}
	}

	 public Mechanic searchMechanic(String mechanicId)
	{
		Mechanic m = null;
		String query = "SELECT `mechanicId`, `mechanicName`, `mechanicSalary`,`joinDate` FROM `mechanic` WHERE `mechanicId`='"+mechanicId+"';";
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
		while(dbc.result.next())
			{
				
				//String mechanicId = dbc.result.getString("mechanicId");
				String mechanicName = dbc.result.getString("mechanicName");
				double mechanicSalary = dbc.result.getDouble("mechanicSalary");
				String joinDate = dbc.result.getString("joinDate");
				
				m = new Mechanic();
				m.setMechanicId(mechanicId);
				m.setMechanicName(mechanicName);
				m.setMechanicSalary(mechanicSalary);
				m.setMechanicJoinDate(joinDate);
			}
			
		}
		catch(Exception ex)
		   {
			  System.out.println("Exception : "+ ex.getMessage());
		   }
	   dbc.closeConnection();
	   return m;
	}  

	public String[][] getMechanicUpdate()
	{
		ArrayList<Mechanic> array = new ArrayList<Mechanic>();
		String query = "SELECT * FROM mechanic;";  
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				String mechanicId = dbc.result.getString("mechanicId");
				String mechanicName = dbc.result.getString("mechanicName");
				double mechanicSalary = dbc.result.getDouble("mechanicSalary");
				String joinDate = dbc.result.getString("joinDate");
				
				Mechanic m = new Mechanic(mechanicId,mechanicName,mechanicSalary,joinDate);
				array.add(m);
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
			data[i][0] = ((Mechanic)obj[i]).getMechanicId();
			data[i][1] = ((Mechanic)obj[i]).getMechanicName();
			data[i][2] = (((Mechanic)obj[i]).getMechanicSalary())+"";
			data[i][3] = (((Mechanic)obj[i]).getMechanicJoinDate())+"";
		}
		return data;
	}

	public void addDriver(Driver d)
	{
       String query = "INSERT INTO driver VALUES ('"+d.getDriverId()+"','"+d.getDriverName()+"','"+d.getDriverSalary()+"','"+d.getDriverPhone()+"','"+d.getDriverJoinDate()+"','"+d.getDrivingLicence()+"');";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex)
		     {
		     	System.out.println("Exception : "+ex.getMessage());
		     }
	}
	public void deleteDriver(String driverId)
	{
       String query = "DELETE from driver WHERE driverId='"+driverId+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex)
		{
			System.out.println("Exception :"+ex.getMessage());
		}
	}
	public void updateDriverInfo(Driver d)
	{
       String query = "UPDATE driver SET driverName = '"+d.getDriverName()+"', driverSalary = '"+d.getDriverSalary()+"', phone = '"+d.getDriverPhone()+"', joinDate = '"+d.getDriverJoinDate()+"', drivingLicence = '"+d.getDrivingLicence()+"' WHERE driverId='"+d.getDriverId()+"';";
		try 
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex)
		{
			System.out.println("Exception : "+ex.getMessage());
		}
	}

	public Driver searchDriver(String driverId)
	{
		Driver d = null;
		String query = "SELECT `driverId`, `driverName`, `driverSalary`,`phone`,`joinDate`,`drivingLicence` FROM `driver` WHERE `driverId`='"+driverId+"';";
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
		while(dbc.result.next())
			{
				
				//String driverId = dbc.result.getString("driverId");
				String driverName = dbc.result.getString("driverName");
				double driverSalary = dbc.result.getDouble("driverSalary");
				int phone = dbc.result.getInt("phone");
				String joinDate = dbc.result.getString("joinDate");
				String drivingLicence = dbc.result.getString("drivingLicence");
				
				d = new Driver();
				d.setDriverId(driverId);
				d.setDriverName(driverName);
				d.setDriverSalary(driverSalary);
				d.setDriverPhone(phone);
				d.setDriverJoinDate(joinDate);
				d.setDrivingLicence(drivingLicence);

			}
			
		}
		catch(Exception ex)
		   {
			  System.out.println("Exception : "+ ex.getMessage());
		   }
	   dbc.closeConnection();
	   return d;
	}

	public String[][] getDriverUpdate()
	{
		ArrayList<Driver> array = new ArrayList<Driver>();
		String query = "SELECT * FROM driver;";  
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				String driverId = dbc.result.getString("driverId");
				String driverName = dbc.result.getString("driverName");
				double driverSalary = dbc.result.getDouble("driverSalary");
				int phone = dbc.result.getInt("Phone");
				String joinDate = dbc.result.getString("joinDate");
				String drivingLicence = dbc.result.getString("drivingLicence");
				
				Driver d = new Driver(driverId,driverName,driverSalary,phone,joinDate,drivingLicence);
				array.add(d);
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception : " +e.getMessage());
		}
		dbc.closeConnection();
		
		
		Object obj[] = array.toArray();
		String data[][] = new String [array.size()][6];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Driver)obj[i]).getDriverId();
			data[i][1] = ((Driver)obj[i]).getDriverName();
			data[i][2] = (((Driver)obj[i]).getDriverSalary())+"";
			data[i][3] = (((Driver)obj[i]).getDriverPhone())+"";
			data[i][4] = ((Driver)obj[i]).getDriverJoinDate();
			data[i][5] = (((Driver)obj[i]).getDrivingLicence())+"";
		}
		return data;
	}
}	

