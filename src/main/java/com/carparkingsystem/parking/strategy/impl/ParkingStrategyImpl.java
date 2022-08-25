package com.carparkingsystem.parking.strategy.impl;

import java.util.TreeSet;

import com.carparkingsystem.parking.strategy.IParkingStrategy;

public class ParkingStrategyImpl implements IParkingStrategy {
  TreeSet<Integer> slotTreeSet;

  public ParkingStrategyImpl() {
    this.slotTreeSet = new TreeSet<>();
  }

  @Override
  public void addSlot(int slotNumber) {
    this.slotTreeSet.add(slotNumber);
  }

  @Override
  public void removeSlot(int slotNumber) {
    this.slotTreeSet.remove(slotNumber);
  }

  @Override
  public Integer getNextSlot() {
    if (slotTreeSet.isEmpty()) {
      throw new RuntimeException("No next slots available....");
    }
    return this.slotTreeSet.first();
  }
}
