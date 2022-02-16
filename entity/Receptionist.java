package entity;

import java.lang.*;

public class Receptionist
{
	private String receptionistId;
	private String receptionistName;
	private double receptionistSalary;
	private String  joinDate;


	public Receptionist(){}

	public Receptionist(String receptionistId,String receptionistName,double receptionistSalary,String joinDate)
	{
		this.receptionistId=receptionistId;
		this.receptionistName=receptionistName;
		this.receptionistSalary=receptionistSalary;
		this.joinDate=joinDate;
	}

	public void setReceptionistId(String receptionistId){this.receptionistId=receptionistId;}
	public void setReceptionistName(String receptionistName){this.receptionistName=receptionistName;}
	public void setReceptionistSalary(double receptionistSalary){this.receptionistSalary=receptionistSalary;}
	public void setReceptionistJoinDate(String joinDate){this.joinDate=joinDate;}

	public String getReceptionistId(){return receptionistId;}
	public String getReceptionistName(){return receptionistName;}
	public double getReceptionistSalary(){return receptionistSalary;}
	public String getReceptionistJoinDate(){return joinDate;}
}