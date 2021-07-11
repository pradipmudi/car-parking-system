package com.carparkingsystem.command;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.carparkingsystem.constants.Constants;

public class Command {

  private String commandName;
  private List<String> parameters;

  public String getCommandName() {
    return commandName;
  }

  public List<String> getParams() {
    return parameters;
  }

  public Command(final String commandLineArguments) {
    final List<String> commandParametersList = Arrays.stream(commandLineArguments.trim().split(Constants.COMMAND_DELIMETER))
        .map(String::trim)
        .filter(token -> (token.length() > 0)).collect(Collectors.toList());

    if (commandParametersList.size() == 0) {
      throw new RuntimeException("Invalid Command");
    }

    commandName = commandParametersList.get(0).toLowerCase();
    commandParametersList.remove(0);
    parameters = commandParametersList;
  }

}