package entity;

import java.lang.*;

public class Manager

{
	private String managerId;
	private String managerName;
	private double managerSalary;
	private String joinDate;


	public Manager(){}

	public Manager(String managerId,String managerName,double managerSalary,String joinDate)
	{
		this.managerId=managerId;
		this.managerName=managerName;
		this.managerSalary=managerSalary;
		this.joinDate=joinDate;
	}

	public void setManagerId(String managerId){this.managerId=managerId;}
	public void setManagerName(String managerName){this.managerName=managerName;}
	public void setManagerSalary(double managerSalary){this.managerSalary=managerSalary;}
	public void setJoinDate(String joinDate){this.joinDate=joinDate;}


	public String getManagerID(){return managerId;}
	public String getManagerName(){return managerName;}
	public double getManagerSalry(){return managerSalary;}
	public String getJoinDate(){return joinDate;}
}