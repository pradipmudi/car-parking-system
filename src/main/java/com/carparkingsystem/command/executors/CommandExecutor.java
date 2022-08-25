package com.carparkingsystem.command.executors;

import com.carparkingsystem.command.Command;
import com.carparkingsystem.display.DisplayOutput;
import com.parkinglotsystem.service.ParkingService;

public abstract class CommandExecutor {
	protected ParkingService parkingLotService;
	protected DisplayOutput displayOutput;
	
	public CommandExecutor(final ParkingService parkingLotService,
			final DisplayOutput displayOutput) {
		this.parkingLotService = parkingLotService;
		this.displayOutput = displayOutput;
	}
	
	public abstract String getName();
	
	public boolean validateCommand(Command command) {
		if(!command.getCommandName().equals(getName()))
			return false;
		return validate(command);
	}
	
	protected abstract boolean validate(Command command);
	
	public abstract void executeCommand(Command command);
}
