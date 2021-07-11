package com.carparkingsystem;

import java.io.IOException;

import com.carparkingsystem.command.executors.factory.CommandExecutorFactory;
import com.carparkingsystem.command.processor.CommandProcessor;
import com.carparkingsystem.display.DisplayOutput;
import com.parkinglotsystem.service.ParkingService;

/**
 * Hello world!
 *
 */
public class ParkingLotSystem 
{
    public static void main( String[] args ) throws IOException
    {
    	final DisplayOutput displayOutput = new DisplayOutput();
        final ParkingService parkingLotService = new ParkingService();
        final CommandExecutorFactory commandExecutorFactory = new CommandExecutorFactory(parkingLotService);
        new CommandProcessor(commandExecutorFactory, displayOutput).process();
    }

	
	
	
}
