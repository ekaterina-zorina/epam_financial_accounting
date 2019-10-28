package by.epam.financial_accounting.controller;

import by.epam.financial_accounting.controller.command.Command;
import by.epam.financial_accounting.controller.command.CommandName;
import by.epam.financial_accounting.controller.impl.*;

import java.util.HashMap;
import java.util.Map;

public final class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();

    CommandProvider() {
        repository.put(CommandName.SIGN_IN, new SignIn());
        repository.put(CommandName.CREATE_TRANSACTION, new CreateTransaction());
        repository.put(CommandName.READ_TRANSACTION, new ReadTransaction());
        repository.put(CommandName.UPDATE_TRANSACTION, new UpdateTransaction());
        repository.put(CommandName.DELETE_TRANSACTION, new DeleteTransaction());
        repository.put(CommandName.WRONG_REQUEST, new WrongRequest());
    }

    Command getCommand(String name) {
        CommandName commandName = null;
        Command command = null;

        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        } catch (IllegalArgumentException | NullPointerException e) {
            command = repository.get(CommandName.WRONG_REQUEST);
        }
        return command;
    }
}
