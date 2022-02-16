package interfaces;

import java.lang.*;
import entity.*;

public interface IEmployeeRepo
{
	public void addEmployee(Employee e);
	public void deleteEmployee(String employeeID);
	public void updateEmployee(Employee e);
	public Employee searchEmployee(String employeeID);
	public String[][] getAllEmployee();
	

}