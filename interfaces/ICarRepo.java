package interfaces;

import java.lang.*;
import entity.*;

public interface ICarRepo
{
	public void addCar(Car cc);
	public void deleteCar(String carLience);
	public void updateCarInfo(Car cc);
	public Car searchCar(String carId);
	public String[][] getCarDetails();

}
