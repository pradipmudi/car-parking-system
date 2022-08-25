package com.carparkingsystem.command.executors.factory;

import java.util.HashMap;
import java.util.Map;

import com.carparkingsystem.command.Command;
import com.carparkingsystem.command.executors.CarNumbersByDriverAgeCommandExecutor;
import com.carparkingsystem.command.executors.CommandExecutor;
import com.carparkingsystem.command.executors.CreateParkingLotCommandExecutor;
import com.carparkingsystem.command.executors.LeaveCommandExecutor;
import com.carparkingsystem.command.executors.ParkCarCommandExecutor;
import com.carparkingsystem.command.executors.SlotByCarNumberCommandExecutor;
import com.carparkingsystem.command.executors.SlotNumberByDriverAgeCommandExecutor;
import com.carparkingsystem.constants.Constants;
import com.carparkingsystem.display.DisplayOutput;
import com.parkinglotsystem.service.ParkingService;

public class CommandExecutorFactory {
	private static Map<String, CommandExecutor> commandExecutorMap = new HashMap<>();
	
	public CommandExecutorFactory(final ParkingService parkingLotService) {
		final DisplayOutput displayOutput = new DisplayOutput();
		commandExecutorMap.put(
				Constants.COMMAND_CREATE_PARKING_LOT,
				new CreateParkingLotCommandExecutor(parkingLotService, displayOutput));
		commandExecutorMap.put(
				Constants.COMMAND_PARK_CAR,
				new ParkCarCommandExecutor(parkingLotService, displayOutput));
		commandExecutorMap.put(
				Constants.COMMAND_LEAVE,
				new LeaveCommandExecutor(parkingLotService, displayOutput));
		commandExecutorMap.put(
				Constants.COMMAND_SLOT_NUMBER_FOR_CAR_WITH_NUMBER,
				new SlotByCarNumberCommandExecutor(parkingLotService, displayOutput));
		commandExecutorMap.put(
				Constants.COMMAND_SLOT_NUMBERS_FOR_DRIVER_OF_AGE,
				new SlotNumberByDriverAgeCommandExecutor(parkingLotService, displayOutput));
		commandExecutorMap.put(
				Constants.COMMAND_VEHICLE_REGISTRATION_NUMBER_FOR_DRIVER_OF_AGE,
				new CarNumbersByDriverAgeCommandExecutor(parkingLotService, displayOutput));
	}
	
	/**
	 * Gets {@link CommandExecutor} for a particular command. It basically uses name of command to
	 * fetch its corresponding executor.
	 *
	 * @param command Command for which executor has to be fetched.
	 * @return Command executor.
	 */
	public CommandExecutor getCommandExecutor(final Command command) {
//		System.out.println(command);
		final CommandExecutor commandExecutor = commandExecutorMap.get(command.getCommandName());
		if (commandExecutor == null) {
			throw new RuntimeException("Invalid Command");
		}
		return commandExecutor;
	}
}
