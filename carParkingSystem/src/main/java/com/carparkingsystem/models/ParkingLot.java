package com.carparkingsystem.models;

import java.util.HashMap;
import java.util.Map;

import com.carparkingsystem.constants.Constants;

public class ParkingLot {
  private int capacity;
  private Map<Integer, Slot> slots;

  public int getCapacity() {
    return capacity;
  }

  public ParkingLot(final int capacity) {
    if (capacity > Constants.PARKING_LOT_MAX_CAPACITY || capacity <= 0) {
      throw new RuntimeException("Parking lot capacity input is invalid...please give a value between 0-1000...");
    }
    this.capacity = capacity;
    this.slots = new HashMap<>();
  }

  public Map<Integer, Slot> getSlots() {
    return slots;
  }

  private Slot getSlot(final Integer slotNumber) {
    if (slotNumber > getCapacity() || slotNumber <= 0) {
      throw new RuntimeException();
    }
    final Map<Integer, Slot> allSlots = getSlots();
    if (!allSlots.containsKey(slotNumber)) {
      allSlots.put(slotNumber, new Slot(slotNumber));
    }
    return allSlots.get(slotNumber);
  }

  public Slot park(final Car car, final Integer slotNumber) {
    final Slot slot = getSlot(slotNumber);
    if (!slot.isSlotVacant()) {
      throw new RuntimeException("Slot is already occupied...");
    }
    slot.registerCar(car);
    return slot;
  }

  public Slot makeSlotFree(final Integer slotNumber) {
    final Slot slot = getSlot(slotNumber);
    slot.unregisterCar();
    return slot;
  }
}
