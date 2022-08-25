package com.carparkingsystem.command.executors;

import java.util.List;

import com.carparkingsystem.command.Command;
import com.carparkingsystem.constants.Constants;
import com.carparkingsystem.display.DisplayOutput;
import com.carparkingsystem.models.ParkingLot;
import com.carparkingsystem.parking.strategy.impl.ParkingStrategyImpl;
import com.carparkingsystem.validators.IntegerValidator;
import com.parkinglotsystem.service.ParkingService;

public class CreateParkingLotCommandExecutor extends CommandExecutor{

	public CreateParkingLotCommandExecutor(final ParkingService parkingService, final DisplayOutput displayOutput) {
		super(parkingService, displayOutput);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void executeCommand(Command command) {
		final int parkingLotCapacity = Integer.parseInt(command.getParams().get(0));
		final ParkingLot parkingLot = new ParkingLot(parkingLotCapacity);
		parkingLotService.createParkingLot(parkingLot, new ParkingStrategyImpl());
		displayOutput.printWithNewLine(
				"Created a parking lot with " + parkingLot.getCapacity() + " slots");
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return Constants.COMMAND_CREATE_PARKING_LOT;
	}

	@Override
	protected boolean validate(Command command) {
		final List<String> params = command.getParams();
		if (params.size() != 1) {
			return false;
		}
		return IntegerValidator.isInteger(params.get(0));
	}

}
