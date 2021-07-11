package com.carparkingsystem.command.executors;

import com.carparkingsystem.command.Command;
import com.carparkingsystem.constants.Constants;
import com.carparkingsystem.display.DisplayOutput;
import com.carparkingsystem.models.Car;
import com.parkinglotsystem.service.ParkingService;

public class ParkCarCommandExecutor extends CommandExecutor {
	
	public ParkCarCommandExecutor(ParkingService parkingLotService, DisplayOutput displayOutput) {
		super(parkingLotService, displayOutput);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void executeCommand(final Command command) {
		// first parameter is the registration number,
		// and the third parameter is the driver age
		final Car car = new Car(command.getParams().get(0), command.getParams().get(2));
		try {
			final Integer slot = parkingLotService.park(car);
			displayOutput.printWithNewLine("Car with vehicle registration number '"+car.getCarNumber()+"' has been parked at slot number " + slot);
		} catch (Exception exception) {
			displayOutput.parkingLotFull();
		}
	}

	@Override
	public String getName() {
		return Constants.COMMAND_PARK_CAR;
	}

	@Override
	protected boolean validate(final Command command) {
		return command.getParams().size() == 3;
	}

}