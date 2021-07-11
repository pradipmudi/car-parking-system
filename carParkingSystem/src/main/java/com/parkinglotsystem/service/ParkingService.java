package com.parkinglotsystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.carparkingsystem.models.Car;
import com.carparkingsystem.models.ParkingLot;
import com.carparkingsystem.models.Slot;
import com.carparkingsystem.parking.strategy.IParkingStrategy;

public class ParkingService {
	  private ParkingLot parkingLot;
	  private IParkingStrategy parkingStrategy;


	  public void createParkingLot(final ParkingLot parkingLot, final IParkingStrategy parkingStrategy) {
	    if (this.parkingLot != null) {
	      throw new RuntimeException("Parking lot already exists.");
	    }
	    this.parkingLot = parkingLot;
	    this.parkingStrategy = parkingStrategy;
	    for (int i = 1; i <= parkingLot.getCapacity(); i++) {
	      parkingStrategy.addSlot(i);
	    }
	  }


	  public Integer park(final Car car) {
	    validateParkingLot();
	    final Integer nextFreeSlot = parkingStrategy.getNextSlot();
	    parkingLot.park(car, nextFreeSlot);
	    parkingStrategy.removeSlot(nextFreeSlot);
	    return nextFreeSlot;
	  }


	  public void makeSlotFree(final Integer slotNumber) {
	    validateParkingLot();
	    parkingLot.makeSlotFree(slotNumber);
	    parkingStrategy.addSlot(slotNumber);
	  }


	  public List<Slot> getOccupiedSlots() {
	    validateParkingLot();
	    final List<Slot> occupiedSlotsList = new ArrayList<>();
	    final Map<Integer, Slot> allSlots = parkingLot.getSlots();

	    for (int i = 1; i <= parkingLot.getCapacity(); i++) {
	      if (allSlots.containsKey(i)) {
	        final Slot slot = allSlots.get(i);
	        if (!slot.isSlotVacant()) {
	          occupiedSlotsList.add(slot);
	        }
	      }
	    }

	    return occupiedSlotsList;
	  }


	  private void validateParkingLot() {
	    if (parkingLot == null) {
	      throw new RuntimeException("Parking lot does not exists to park.");
	    }
	  }


	  public List<Slot> getSlotsByDriverAge(final String driverAge) {
	    final List<Slot> occupiedSlots = getOccupiedSlots();
	    return occupiedSlots.stream()
	        .filter(slot -> slot.getParkedCar().getDriverAge().equals(driverAge))
	        .collect(Collectors.toList());
	  }


	}
