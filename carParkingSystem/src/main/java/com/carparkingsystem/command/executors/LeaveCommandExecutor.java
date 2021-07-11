package com.carparkingsystem.command.executors;

import com.carparkingsystem.command.Command;
import com.carparkingsystem.constants.Constants;
import com.carparkingsystem.display.DisplayOutput;
import com.carparkingsystem.models.Slot;
import com.carparkingsystem.validators.IntegerValidator;
import com.parkinglotsystem.service.ParkingService;

public class LeaveCommandExecutor extends CommandExecutor {

	public LeaveCommandExecutor(final ParkingService parkingLotService, final DisplayOutput displayOutput) {
		super(parkingLotService, displayOutput);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return Constants.COMMAND_LEAVE;
	}

	@Override
	protected boolean validate(Command command) {
		// TODO Auto-generated method stub
		return command.getParams().size() == 1 ? IntegerValidator.isInteger(command.getParams().get(0)) : false;
	}

	@Override
	public void executeCommand(Command command) {
		final int slotNum = Integer.parseInt(command.getParams().get(0));
	    Slot freedSlot = parkingLotService.makeSlotFree(slotNum);
	    displayOutput.printWithNewLine("Slot number " + slotNum + " vacated, the car with vehicle registration number '"+freedSlot.getParkedCar().getCarNumber()+"' left the space, the driver of the car was of age "+freedSlot.getParkedCar().getDriverAge());
	}

}
