package repository;

import java.lang.*;
import java.util.ArrayList;
import entity.*;
import interfaces.*;

public class ManagerRepo implements IEmployeeRepo,ICarRepo,IDriverRepo
{
	DatabaseConnection dbc;

	public ManagerRepo()
	{
		dbc = new DatabaseConnection();
	}
	public void addEmployee(Employee e)
	{
		String query = "INSERT INTO employee VALUES ('"+e.getEmployeeId()+"','"+e.getEmployeeName()+"','"+e.getEmployeeSalary()+"','"+e.getJobType()+"','"+e.getEmployeeJoinDate()+"');";
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
	public void deleteEmployee(String employeeId)
	{
		String query = "DELETE from employee WHERE employeeId='"+employeeId+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex)
		{
			System.out.println("Exception : " + ex.getMessage());
		}
	}
	public void updateEmployee(Employee e)
	{
		String query = "UPDATE employee SET employeeId='"+e.getEmployeeId()+"', employeeName = '"+e.getEmployeeName()+"', employeeSalary = '"+e.getEmployeeSalary()+"', jobtype = '"+e.getJobType()+"', joinDate = '"+e.getEmployeeJoinDate()+"' WHERE employeeId='"+e.getEmployeeId()+"';";
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
	public Employee searchEmployee(String employeeId)
	{
		Employee emp = null;
		String query = "SELECT `employeeName`, `employeeSalary`,`jobType`,`joinDate` FROM `employee` WHERE `employeeId`='"+employeeId+"';";
		try
		{
			System.out.println(query);
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
		while(dbc.result.next())
			{
				
				//String employeeId = dbc.result.getString("employeeId");
				String employeeName = dbc.result.getString("employeeName");
				double employeeSalary = dbc.result.getDouble("employeeSalary");
				String jobType = dbc.result.getString("jobType");
				String joinDate = dbc.result.getString("joinDate");
				
				emp = new Employee();
				emp.setEmployeeId(employeeId);
				emp.setEmployeeName(employeeName);
				emp.setEmployeeSalary(employeeSalary);
				emp.setJobType(jobType);
				emp.setEmployeeJoinDate(joinDate);
			}
			
		}
		catch(Exception ex)
		   {
			  System.out.println("Exception : "+ ex.getMessage());
		   }
	   dbc.closeConnection();
	   return emp;
    }
	public String[][] getAllEmployee()
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
		catch(Exception ex){System.out.println("Exception : " + ex.getMessage());}
		dbc.closeConnection();
		
		
		Object obj[] = array.toArray();
		String data[][] = new String [array.size()][5];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Employee)obj[i]).getEmployeeId();
			data[i][1] = ((Employee)obj[i]).getEmployeeName();
			data[i][2] = (((Employee)obj[i]).getEmployeeSalary()+"");
			data[i][3] = (((Employee)obj[i]).getJobType());
			data[i][4] = (((Employee)obj[i]).getEmployeeJoinDate())+"";
		}
		return data;
	}

	public void addCar(Car cc)
	{
		String query = "INSERT INTO car VALUES ('"+cc.getCarId()+"','"+cc.getBrand()+"','"+cc.getCarLicence()+"','"+cc.getReservationStatus()+"','"+cc.getCarType()+"',"+cc.getNumberOfSeat()+");";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex)
		     {
		     	System.out.println("Exception : " + ex.getMessage());
		     }
	}
	public void deleteCar(String carId)
	{
		String query = "DELETE from car WHERE carId='"+carId+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex)
		{
			System.out.println("Exception : " + ex.getMessage());
		}
	}
	public void updateCarInfo(Car cc)
	{
		String query = "UPDATE car SET brand='"+cc.getBrand()+"', carLicence = '"+cc.getCarLicence()+"', reservationStatus = '"+cc.getReservationStatus()+"', carType = '"+cc.getCarType()+"', numberOfseat = "+cc.getNumberOfSeat()+" WHERE carId='"+cc.getCarId()+"';";
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
		String query = "SELECT `brand`,`carLicence`, `reservationStatus`,`carType`,`numberOfseat` FROM `car` WHERE `carId`='"+carId+"';";
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
		while(dbc.result.next())
			{
				
				//String carId = dbc.result.getString("carId");
				String brand = dbc.result.getString("brand");
				String carLicence =dbc.result.getString("carLicence");
				String reservationStatus = dbc.result.getString("reservationStatus");
				String carType = dbc.result.getString("carType");
				String numberOfseat = dbc.result.getString("numberOfseat");
				
				cc = new Car();
				cc.setCarId(carId);
				cc.setBrand(brand);
				cc.setCarLicence(carLicence);
				cc.setReservationStatus(reservationStatus);
				cc.setCarType(carType);
				cc.setNumberOfSeat(Integer.parseInt(numberOfseat));
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
		String data[][] = new String [array.size()][6];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Car)obj[i]).getCarId();
			data[i][1] = ((Car)obj[i]).getBrand();
			data[i][2] = ((Car)obj[i]).getCarLicence();
			data[i][3] = ((Car)obj[i]).getReservationStatus();
			data[i][4] = (((Car)obj[i]).getCarType());
			data[i][5] = (((Car)obj[i]).getNumberOfSeat())+"";
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
			System.out.println(ex.getMessage());
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
			System.out.println(ex.getMessage());
		}
	}

	public Driver searchDriver(String driverId)
	{
		Driver d = null;
		String query = "SELECT  `driverName`, `driverSalary`,`phone`,`joinDate`,`drivingLicence` FROM `driver` WHERE `driverId`='"+driverId+"';";
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
			data[i][2] = (((Driver)obj[i]).getDriverSalary()+"");
			data[i][3] = (((Driver)obj[i]).getDriverPhone()+"");
			data[i][4] = ((Driver)obj[i]).getDriverJoinDate();
			data[i][5] = (((Driver)obj[i]).getDrivingLicence())+"";
		}
		return data;
	}

}