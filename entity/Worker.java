package entity;

import java.lang.*;

public class Worker
{
	private String workerId;
	private String workerName;
	private double workerSalary;
	private String joinDate;


	public Worker(){}

	public Worker(String workerId,String workerName,double workerSalary,String joinDate)
	{
		this.workerId=workerId;
		this.workerName=workerName;
		this.workerSalary=workerSalary;
		this.joinDate=joinDate;
	}

	public void setWorkerId(String workerId){this.workerId=workerId;}
	public void setWorkerName(String workerName){this.workerName=workerName;}
	public void setWorkerSalary(double workerSalary){this.workerSalary=workerSalary;}
	public void setWorkerJoinDate(String joinDate){this.joinDate=joinDate;}


	public String getWorkerId(){return workerId;}
	public String getWorkerName(){return workerName;}
	public double getWorkerSalary(){return workerSalary;}
	public String getWorkerJoinDate(){return joinDate;}
}