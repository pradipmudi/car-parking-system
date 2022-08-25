package com.carparkingsystem.command.executors;

import java.util.List;
import java.util.stream.Collectors;

import com.carparkingsystem.command.Command;
import com.carparkingsystem.constants.Constants;
import com.carparkingsystem.display.DisplayOutput;
import com.carparkingsystem.models.Slot;
import com.parkinglotsystem.service.ParkingService;

public class CarNumbersByDriverAgeCommandExecutor extends CommandExecutor {

	public CarNumbersByDriverAgeCommandExecutor(final ParkingService parkingLotService, final DisplayOutput displayOutput) {
		super(parkingLotService, displayOutput);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return Constants.COMMAND_VEHICLE_REGISTRATION_NUMBER_FOR_DRIVER_OF_AGE;
	}

	@Override
	protected boolean validate(Command command) {
		// TODO Auto-generated method stub
		return command.getParams().size() == 1;
	}

	@Override
	public void executeCommand(Command command) {
		// TODO Auto-generated method stub
		final List<Slot> slotsByDriverAge = parkingLotService.getSlotsByDriverAge(command.getParams().get(0));
	    if (slotsByDriverAge.isEmpty()) {
	      displayOutput.notFound();
	    } else {
	      final String result =
	          slotsByDriverAge.stream()
	              .map(slot -> slot.getParkedCar().getCarNumber().toString())
	              .collect(Collectors.joining(", "));
	      displayOutput.printWithNewLine(result);
	    }
	}

}
