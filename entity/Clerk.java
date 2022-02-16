package entity;

import java.lang.*;

public class Clerk
{
	private String clerkId;
	private String clerkName;
	private double clerkSalary;
	private String joinDate;

	public Clerk(){}

	public Clerk(String clerkId,String clerkName,double clerkSalary,String joinDate)
	{
		this.clerkId=clerkId;
		this.clerkName=clerkName;
		this.clerkSalary=clerkSalary;
		this.joinDate=joinDate;
	}

	public void setClerkId(String clerkId){this.clerkId=clerkId;}
	public void setClerkName(String clerkName){this.clerkName=clerkName;}
	public void setClerkSalary(double clerkSalary){this.clerkSalary=clerkSalary;}
	public void setClerkJoinDate(String joinDate){this.joinDate=joinDate;}


	public String getClerkId(){return clerkId;}
	public String getClerkName(){return clerkName;}
	public double getClerkSalary(){return clerkSalary;}
	public String getClerkJoinDate(){return joinDate;}
}