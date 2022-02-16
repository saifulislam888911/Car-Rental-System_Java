package entity;

import java.lang.*;

public class Driver
{
	private String driverId;
	private String driverName;
	private double driverSalary;
	private int phone;
	private String joinDate;
	private String drivingLicence;

	public Driver(){}

	public Driver(String driverId,String driverName,double driverSalary,int phone,String joinDate,String drivingLicence)
	{
		this.driverId=driverId;
		this.driverName=driverName;
		this.driverSalary=driverSalary;
		this.phone=phone;
		this.joinDate=joinDate;
		this.drivingLicence=drivingLicence;
	}


	public void setDriverId(String driverId){this.driverId=driverId;}
	public void setDriverName(String driverName){this.driverName=driverName;}
	public void setDriverSalary(double driverSalary){this.driverSalary=driverSalary;}
	public void setDriverPhone(int phone){this.phone=phone;}
	public void setDriverJoinDate(String joinDate){this.joinDate=joinDate;}
	public void setDrivingLicence(String drivingLicence){this.drivingLicence=drivingLicence;}


	public String getDriverId(){return driverId;}
	public String getDriverName(){return driverName;}
	public double getDriverSalary(){return driverSalary;}
	public int getDriverPhone(){return phone;}
	public String getDriverJoinDate(){return joinDate;}
	public String getDrivingLicence(){return drivingLicence;}
}