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

	private CommandExecutorFactory commandExecutorFactory;
	private DisplayOutput displayOutput;

	public CommandProcessor(final CommandExecutorFactory commandExecutorFactory, final DisplayOutput displayOutput) throws IOException {
		this.commandExecutorFactory = commandExecutorFactory;
	    this.displayOutput = displayOutput;
	    process(commandExecutorFactory);
	}
	
	public void process(CommandExecutorFactory commandExecutorFactory2) throws IOException {
		final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    while (true) {
	      final String input = reader.readLine();
	      final Command command = new Command(input);
	      if (command.getCommandName().equals(Constants.COMMAND_TERMINATE)) {
	    	  displayOutput.printWithNewLine("Terminating the program...exiting the command line interface....");
	    	  break;
	      }
	      processCommand(command, commandExecutorFactory);
	    }
	}
	
	protected static void processCommand(final Command command, CommandExecutorFactory commandExecutorFactory) {
		final CommandExecutor commandExecutor = commandExecutorFactory.getCommandExecutor(command);
		if (commandExecutor.validateCommand(command)) {
			commandExecutor.executeCommand(command);
		} else {
			throw new RuntimeException("Invalid command!!");
		}
	}

}
