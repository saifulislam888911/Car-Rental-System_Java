package entity;

import java.lang.*;
import java.util.*;

public class Employee

{
	private String employeeId;
	private String employeeName;
	private double employeeSalary;
	private String jobType;
	private String joinDate;


	public Employee(){}

	public Employee(String employeeId,String employeeName,double employeeSalary,String jobType,String joinDate)
	{
		this.employeeId=employeeId;
		this.employeeName=employeeName;
		this.employeeSalary=employeeSalary;
		this.jobType=jobType;
		this.joinDate=joinDate;
	}

	public void setEmployeeId(String employeeId){this.employeeId=employeeId;}
	public void setEmployeeName(String employeeName){this.employeeName=employeeName;}
	public void setEmployeeSalary(double employeeSalary){this.employeeSalary=employeeSalary;}
	public void setJobType(String jobType){this.jobType=jobType;}
    public void setEmployeeJoinDate(String joinDate){this.joinDate=joinDate;}

    public String getEmployeeId(){return employeeId;}
    public String getEmployeeName(){return employeeName;}
    public double getEmployeeSalary(){return employeeSalary;}
    public String getJobType(){return jobType;}
    public String getEmployeeJoinDate(){return joinDate;}

}