package com.carparkingsystem.models;

public class Car {
	String carNumber;
	String driverAge;
	
	public Car(String carNumber, String driverAge) {
		this.carNumber = carNumber;
		this.driverAge = driverAge;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public String getDriverAge() {
		return driverAge;
	}

	
}
