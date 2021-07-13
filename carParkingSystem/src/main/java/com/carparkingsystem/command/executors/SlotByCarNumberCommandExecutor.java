package com.carparkingsystem.command.executors;

import java.util.List;

import com.carparkingsystem.command.Command;
import com.carparkingsystem.constants.Constants;
import com.carparkingsystem.display.DisplayOutput;
import com.carparkingsystem.models.Slot;
import com.parkinglotsystem.service.ParkingService;
import java.util.Optional;

public class SlotByCarNumberCommandExecutor extends CommandExecutor {

	public SlotByCarNumberCommandExecutor(final ParkingService parkingLotService, final DisplayOutput displayOutput) {
		super(parkingLotService, displayOutput);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return Constants.COMMAND_SLOT_NUMBER_FOR_CAR_WITH_NUMBER;
	}

	@Override
	protected boolean validate(Command command) {
		// TODO Auto-generated method stub
		return command.getParams().size() == 1;
	}

	@Override
	public void executeCommand(Command command) {
		final List<Slot> occupiedSlots = parkingLotService.getOccupiedSlots();
	    final String regNumberToFind = command.getParams().get(0);
	    final Optional<Slot> foundSlot = occupiedSlots.stream()
	        .filter(slot -> slot.getParkedCar().getCarNumber().equals(regNumberToFind))
	        .findFirst();
	    if (foundSlot.isPresent()) {
	      displayOutput.printWithNewLine(foundSlot.get().getSlotNumber().toString());
	    } else {
	      displayOutput.notFound();
	    }
		
	}

}
