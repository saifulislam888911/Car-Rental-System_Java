package entity;

import java.lang.*;

public class Car
{
	private String carId;
	private String brand;
	private String carLicence;
	private String reservationStatus;
	private String carType;
	private int numberOfseat;

	public Car(){}

	public Car(String carId,String brand,String carLicence,String reservationStatus,String carType,int numberOfseat)
	{
		this.carId=carId;
		this.brand=brand;
		this.carLicence=carLicence;
		this.reservationStatus=reservationStatus;
		this.carType=carType;
		this.numberOfseat=numberOfseat;
	}

    public void setCarId(String carId){this.carId=carId;}
	public void setBrand(String brand){this.brand=brand;}
	public void setCarLicence(String carLicence){this.carLicence=carLicence;}
	public void setReservationStatus(String reservationStatus){this.reservationStatus=reservationStatus;}
	public void setCarType(String carType){this.carType=carType;}
	public void setNumberOfSeat(int numberOfseat){this.numberOfseat=numberOfseat;}

    
    public String getCarId(){return carId;}
	public String getBrand(){return brand;}
	public String getCarLicence(){return carLicence;}
	public String getReservationStatus(){return reservationStatus;}
	public String getCarType(){return carType;}
	public int getNumberOfSeat(){return numberOfseat;}
}