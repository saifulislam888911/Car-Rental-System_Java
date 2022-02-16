package entity;

import java.lang.*;

public class Mechanic
{
	private String mechanicId;
	private String mechanicName;
	private double mechanicSalary;
	private String joinDate;


	public Mechanic(){}

	public Mechanic(String mechanicId,String mechanicName,double mechanicSalary,String joinDate)
	{
		this.mechanicId=mechanicId;
		this.mechanicName=mechanicName;
		this.mechanicSalary=mechanicSalary;
		this.joinDate=joinDate;
	}

	public void setMechanicId(String mechanicId){this.mechanicId=mechanicId;}
	public void setMechanicName(String mechanicName){this.mechanicName=mechanicName;}
	public void setMechanicSalary(double mechanicSalary){this.mechanicSalary=mechanicSalary;}
	public void setMechanicJoinDate(String joinDate){this.joinDate=joinDate;}


	public String getMechanicId(){return mechanicId;}
	public String getMechanicName(){return mechanicName;}
	public double getMechanicSalary(){return mechanicSalary;}
	public String getMechanicJoinDate(){return joinDate;}
}