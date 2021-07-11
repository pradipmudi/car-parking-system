package com.carparkingsystem.parking.strategy;

public interface IParkingStrategy {

	public void addSlot(int slotNumber);
	
	public void removeSlot(int slotNumber);
	
	public Integer getNextSlot();
}