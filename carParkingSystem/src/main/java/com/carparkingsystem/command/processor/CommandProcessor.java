package com.carparkingsystem.command.processor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.carparkingsystem.command.Command;
import com.carparkingsystem.command.executors.CommandExecutor;
import com.carparkingsystem.command.executors.factory.CommandExecutorFactory;
import com.carparkingsystem.constants.Constants;
import com.carparkingsystem.display.DisplayOutput;

public class CommandProcessor {

	private static CommandExecutorFactory commandExecutorFactory;
	private DisplayOutput displayOutput;

	public CommandProcessor(final CommandExecutorFactory commandExecutorFactory, final DisplayOutput displayOutput) {
		CommandProcessor.commandExecutorFactory = commandExecutorFactory;
	    this.displayOutput = displayOutput;
	}
	
	public void process() throws IOException {
		final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    while (true) {
	      final String input = reader.readLine();
	      final Command command = new Command(input);
	      processCommand(command);
	      if (command.getCommandName().equals(Constants.COMMAND_TERMINATE)) {
	        break;
	      }
	    }
	}
	
	protected static void processCommand(final Command command) {
		final CommandExecutor commandExecutor = commandExecutorFactory.getCommandExecutor(command);
		if (commandExecutor.validateCommand(command)) {
			commandExecutor.executeCommand(command);
		} else {
			throw new RuntimeException("Invalid command!!");
		}
	}

}
