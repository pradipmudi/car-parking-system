package com.carparkingsystem.models;

public class Slot {
	private Integer slotNumber;
	private Car parkedCar;
	
	// we are making it final here cause
	// once we initialize a slot number,
	// it should not be changed for that object
	public Slot(final int slotNumber) {
		this.slotNumber = slotNumber;
	}

	public Integer getSlotNumber() {
		return slotNumber;
	}

	public Car getParkedCar() {
		return parkedCar;
	}

	public boolean isSlotVacant() {
		return parkedCar == null;
	}
	
	public void registerCar(Car car) {
		this.parkedCar = car;
	}
	
	public void unregisterCar() {
		this.parkedCar = null;
	}
	
	
}
