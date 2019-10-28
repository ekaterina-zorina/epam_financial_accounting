package by.epam.financial_accounting.controller;

import by.epam.financial_accounting.controller.command.Command;

public class Controller {
    private static final Controller instance = new Controller();
    private final CommandProvider provider = new CommandProvider();

    public static Controller getInstance() {
        return instance;
    }

    public String executeTask(String request) {
        String[] params = request.split(" ");
        String commandName;
        Command executionCommand;

        commandName = params[0];
        executionCommand = provider.getCommand(commandName);

        String response;
        response = executionCommand.execute(request);

        return response;
    }
}
